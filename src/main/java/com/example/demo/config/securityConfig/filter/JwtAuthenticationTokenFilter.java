package com.example.demo.config.securityConfig.filter;



import com.example.demo.config.securityConfig.token.WeChatAuthenticationToken;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//定义JWT认证过滤器
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    RedisCache redisCache;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token=request.getHeader("token");
        if(!StringUtils.hasText(token)){
            //假如是空字符串
            filterChain.doFilter(request,response);
            return;
        }
        //解析token
        if(!JwtUtil.verify(token)){
            //todo 这是失败的token，要返回失败
        }
        //从redis中获取用户信息
        Claims claims=JwtUtil.getClaim(token);
        String userId=claims.get("userId").toString();
       Object object= redisCache.getCacheObject("login_"+userId);
       if(object==null){
           //todo 这是登录过期的，要重新登录
       }
        Collection collection=(Collection) object;
        //将用户信息存入SecurityContextHolder
        //TODO 获取权限信息存入到Authentication中
        WeChatAuthenticationToken weChatAuthenticationToken=new WeChatAuthenticationToken(userId,collection);
//        LoginUser loginUser=new LoginUser(new MyUser());
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
//                new UsernamePasswordAuthenticationToken(loginUser,null,null);

//        System.out.println("hhhh你是什么牛i吗");
//        List<String> stringList=new ArrayList<>();
//        stringList.add("user");
//        stringList.add("mmm");
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (String permissionCode : stringList) {
//            if (permissionCode != null && permissionCode != "") {
//                GrantedAuthority grantedAuthority =
//                        new SimpleGrantedAuthority(permissionCode);
//                authorities.add(grantedAuthority);
//            }
//        }
//        WeChatAuthenticationToken weChatAuthenticationToken=new WeChatAuthenticationToken("openid",authorities);
//        SecurityContextHolder.getContext().setAuthentication(weChatAuthenticationToken);
        //放行
        System.out.println("你好");
        filterChain.doFilter(request,response);
    }
}
