package com.example.demo.config.securityConfig.filter;



import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.demo.config.securityConfig.token.WeChatAuthenticationToken;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.RedisCache;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.*;
import java.util.concurrent.TimeUnit;

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
            filterChain.doFilter(request,response);
         return;
        }
        if(!JwtUtil.verify(token)){

            response.setContentType("application/json; charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(403);
            Map result = new HashMap();
            result.put("code", 403);
//        result.put("codeRtn", false);
            // 错误信息
            result.put("errorMsg","token验证失败");
           ObjectMapper objectMapper= new ObjectMapper();
            String json = objectMapper.writeValueAsString(result);
            response.getWriter().write(json);
            response.getWriter().flush();
        }else {
            //从redis中获取用户信息
            Claims claims=JwtUtil.getClaim(token);
            String userId=claims.get("userId").toString();
            Object object= redisCache.getCacheObject("login_"+userId);
            if(object==null){
                //todo 这是登录过期的，要重新登录
                System.out.println("已经过期了");
                response.setContentType("application/json; charset=utf-8");
                response.setCharacterEncoding("UTF-8");
                response.setStatus(403);
                Map result = new HashMap();
                result.put("code", 403);
//        result.put("codeRtn", false);
                // 错误信息
                result.put("errorMsg","登录过期");
                ObjectMapper objectMapper= new ObjectMapper();
                String json = objectMapper.writeValueAsString(result);
                response.getWriter().write(json);
                response.getWriter().flush();
            }
          if(!redisCache.expire("login_"+userId,30,TimeUnit.MINUTES)){
              response.setContentType("application/json; charset=utf-8");
              response.setCharacterEncoding("UTF-8");

              Map result = new HashMap();
              result.put("code", 505);
//        result.put("codeRtn", false);
              // 错误信息
              result.put("errorMsg","设置redis过期时间失败");
              ObjectMapper objectMapper= new ObjectMapper();
              String json = objectMapper.writeValueAsString(result);
              response.getWriter().write(json);
              response.getWriter().flush();
          }
          Map map=new HashMap();
          map.put("userId",userId);
           token= JwtUtil.generate(map);
           response.setHeader("token",token);
//            List<Record> msgList = JSON.parseArray(msgEncap.getString("msgList"), Record.class);
//            List<GrantedAuthority> collection= JSON.parseArray(JSON.toJSONString(object),List.class);
            Collection<GrantedAuthority> collection=(Collection<GrantedAuthority>)object;
            System.out.println(collection.toString());
            WeChatAuthenticationToken weChatAuthenticationToken=new WeChatAuthenticationToken(userId,collection);
            SecurityContextHolder.getContext().setAuthentication(weChatAuthenticationToken);
        }

        //将用户信息存入SecurityContextHolder
        //TODO 获取权限信息存入到Authentication中

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
