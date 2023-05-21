package com.example.demo.config.securityConfig.filter;

import com.example.demo.config.securityConfig.token.PhoneAuthenticationToken;
import com.example.demo.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PhoneAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if (!request.getMethod().equals(HttpMethod.GET.name())) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        String phone = request.getParameter("phone");
        String code = request.getParameter("code");
        PhoneAuthenticationToken phoneAuthenticationToken=new PhoneAuthenticationToken(phone,code);
        phoneAuthenticationToken.setDetails(authenticationDetailsSource.buildDetails(request));

        return this.getAuthenticationManager().authenticate(phoneAuthenticationToken);

    }
    public PhoneAuthenticationFilter() {
        super("/admin/login");
        //super.setAuthenticationFailureHandler(new MyAuthenticationFailureHandler());
    }
}
