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
        System.out.println("进入到jwt区域");
        if(!StringUtils.hasText(token)){
            System.out.println("可能是空的");
            filterChain.doFilter(request,response);
         return;
        }
        System.out.println("这是旧的token   "+token);
        if(!JwtUtil.verify(token)){

            System.out.println("token验证失败");
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
            return;
        }else {
            //从redis中获取用户信息
            Claims claims=JwtUtil.getClaim(token);
            String userId=claims.get("userId").toString();
            Object object= redisCache.getCacheObject("login_"+token);
            System.out.println("到这一部了");
            if(object==null){
                System.out.println("这是空的撒酒疯噶三个房间");
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
                return;
            }


            System.out.println("到这一步就是外的事情了");
//              redisCache.deleteObject("login_"+token);
//              Map map=new HashMap();
//              map.put("userId",userId);
//              token= JwtUtil.generate(map);
//            System.out.println("这是新的token  "+token);
              redisCache.setCacheObject("login_"+token,object,3000,TimeUnit.MINUTES);
              response.setHeader("token",token);
        /*      response.setContentType("application/json; charset=utf-8");
              response.setCharacterEncoding("UTF-8");*/
//
//              Map result = new HashMap();
//              result.put("code", 505);
////        result.put("codeRtn", false);
//              // 错误信息
//              result.put("errorMsg","设置redis过期时间失败");
//              ObjectMapper objectMapper= new ObjectMapper();
//              String json = objectMapper.writeValueAsString(result);
//              response.getWriter().write(json);
//              response.getWriter().flush();

//
//           response.setHeader("token",token);
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
