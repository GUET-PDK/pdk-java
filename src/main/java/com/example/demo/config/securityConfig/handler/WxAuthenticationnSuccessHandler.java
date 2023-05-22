package com.example.demo.config.securityConfig.handler;

import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.RedisCache;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author: xxm
 * 功能描述: 微信登陆成功后操作
 * @date: 2021/3/31 13:40
 * @param:
 * @return:
 */
@Service
public class WxAuthenticationnSuccessHandler implements AuthenticationSuccessHandler {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    RedisCache redisCache;
    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        // 返回json数据
        String userId=authentication.getPrincipal().toString();
        Map jwtMap=new HashMap();
        jwtMap.put("userId",userId);

       String token= JwtUtil.generate(jwtMap);

    redisCache.setCacheObject("login_"+token,authentication.getAuthorities(),3000, TimeUnit.MINUTES);
        Map result = new HashMap();
        result.put("code", 200);
//        result.put("codeRtn", false);
        // 错误信息
        result.put("Msg", "登录成功");

        String json = objectMapper.writeValueAsString(result);
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("token",token);
        response.getWriter().write(json);
    }
}
