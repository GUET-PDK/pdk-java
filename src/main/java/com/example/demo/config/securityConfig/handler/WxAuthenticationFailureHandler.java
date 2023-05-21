package com.example.demo.config.securityConfig.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author: xxm
 * 功能描述: 微信登录验证失败操作
 * @date: 2021/3/31 13:40
 * @param:
 * @return:
 */
@Service
public class WxAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException, IOException {
        // 返回json数据
        Map result = new HashMap();
        result.put("code", 6050);
//        result.put("codeRtn", false);
        // 错误信息
        result.put("errorMsg", exception.getMessage());
        exception.printStackTrace();;
        String json = objectMapper.writeValueAsString(result);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(json);
    }
}
