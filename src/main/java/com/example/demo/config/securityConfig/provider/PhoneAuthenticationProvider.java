package com.example.demo.config.securityConfig.provider;

import com.example.demo.config.exception.AppException;
import com.example.demo.config.exception.AppExceptionCodeMsg;
import com.example.demo.config.securityConfig.token.PhoneAuthenticationToken;
import com.example.demo.config.securityConfig.token.WeChatAuthenticationToken;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

public class PhoneAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    RedisCache redisCache;

    @Autowired
    UserMapper userMapper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        PhoneAuthenticationToken authenticationToken=(PhoneAuthenticationToken)authentication;
        String phone=(String)authenticationToken.getPrincipal();//获取电话
        String code=(String)authenticationToken.getCredentials();//获取验证码

       String code1= (String)redisCache.getCacheObject("Phone_"+phone);
       if(code1==null){
           throw new BadCredentialsException("验证码无效");
       }
      if(code1.equals(code)){
          redisCache.deleteObject("Phone_"+phone);
          Map map=new HashMap();
          map.put("user_phone",phone);
          List<User> list=userMapper.selectByMap(map);
          Set permissionSet=new HashSet();
          if(list.size()==0){

              throw new BadCredentialsException("该手机号没有用户");
          }
          permissionSet = userMapper.selectPermissionByUserId(list.get(0).getUserId());
          List<GrantedAuthority> authorities = new ArrayList<>();
          for (Object permissionCode : permissionSet) {
              String permission= permissionCode.toString();
              if (permission != null && permission != "") {
                  GrantedAuthority grantedAuthority =
                          new SimpleGrantedAuthority(permission);
                  authorities.add(grantedAuthority);
              }
          }
          String userId=list.get(0).getUserId();
        PhoneAuthenticationToken phoneAuthenticationToken=new PhoneAuthenticationToken(userId,"",authorities);

          return phoneAuthenticationToken;
      }

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

        return PhoneAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
