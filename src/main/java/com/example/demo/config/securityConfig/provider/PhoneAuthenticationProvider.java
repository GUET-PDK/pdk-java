package com.example.demo.config.securityConfig.provider;

import com.example.demo.config.securityConfig.token.PhoneAuthenticationToken;
import com.example.demo.config.securityConfig.token.WeChatAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class PhoneAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        PhoneAuthenticationToken authenticationToken=(PhoneAuthenticationToken)authentication;
        String phone=(String)authenticationToken.getPrincipal();//获取电话
        String code=(String)authenticationToken.getCredentials();//获取验证码
        //todo 验证码校验，然后返回数据库信息


//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (Object permissionCode : permissionSet) {
//            String permission= permissionCode.toString();
//            if (permission != null && permission != "") {
//                GrantedAuthority grantedAuthority =
//                        new SimpleGrantedAuthority(permission);
//                authorities.add(grantedAuthority);
//            }
//        }
//
//        PhoneAuthenticationToken authenticationResult = new PhoneAuthenticationToken(phone,code, authorities);
//
//        return authenticationResult;
return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
