package com.example.demo.config.securityConfig.provider;


import com.example.demo.config.securityConfig.token.WeChatAuthenticationToken;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.cxb.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

/**
 * @author: xxm
 * @description:
 * @date: 2021/3/11 16:07
 */
public class WeChatAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserMapper userMapper;


    @Autowired
    IUserService userService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if (authentication.isAuthenticated()) {
            return authentication;
        }
        //todo 这里检查数据库看有没有这个用户
        WeChatAuthenticationToken authenticationToken = (WeChatAuthenticationToken) authentication;
        String openid = (String)authenticationToken.getPrincipal();
        System.out.println(openid+"     测试测试");
//        if(openid.equals("bug")){
//            throw new BadCredentialsException("微信授权openid无效，请重新登陆");
//        }
        String resultUserId="";
        Map map=new HashMap();
        map.put("open_id",openid);
        List<User> list=userMapper.selectByMap(map);
        Set permissionSet=new HashSet();
        if(list.size()==0){
            System.out.println("找不到哈哈哈哈哈哈哈哈哈");
            User user=new User();
            user.setOpenId(openid);
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
           String userId= UUID.randomUUID().toString();
           resultUserId=userId;
            user.setUserId(userId);
            userService.addNewUser(user);
           permissionSet = userMapper.selectPermissionByUserId(userId);
        }else {
            permissionSet = userMapper.selectPermissionByUserId(list.get(0).getUserId());
            resultUserId=list.get(0).getUserId();
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Object permissionCode : permissionSet) {
          String permission= permissionCode.toString();
            if (permission != null && permission != "") {
                GrantedAuthority grantedAuthority =
                        new SimpleGrantedAuthority(permission);
                authorities.add(grantedAuthority);
            }
        }

        WeChatAuthenticationToken authenticationResult = new WeChatAuthenticationToken(resultUserId, authorities);

        return authenticationResult;
//        //获取过滤器封装的token信息
//        WeChatAuthenticationToken authenticationToken = (WeChatAuthenticationToken) authentication;
//        String openid = (String)authenticationToken.getPrincipal();
//        SysUser user = null;
//        UserWeChatDto uwcDto = new UserWeChatDto();
//        uwcDto.setOpenId(openid);
//        List<UserWeChatDto> uwcList = userWeChatClient.getListByParam(uwcDto);
//        if (null != uwcList && uwcList.size()==1) {
//            UserWeChatDto userWeChatDto = uwcList.get(0);
//            //微信账号已经与网站账号关联
//            //根据用户id查询用户
//            user = userControllerClient.getUserById(userWeChatDto.getUserId());
//            //存放session
//            HttpServletRequest request =
//                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//            HttpSession session = request.getSession();
//            session.setAttribute("username", user.getUsername());
//        } else {
//            //微信账号没有关联网站账号
//            throw new BadCredentialsException("微信授权openid无效，请重新登陆");
//        }
////        不通过
//        if (user == null) {
//            throw new BadCredentialsException("微信授权openid无效，请重新登陆");
//        }
//        // 根用户拥有全部的权限
//        List<String> permissionCodess = userControllerClient.findPermissionByAdminUserName(user.getUsername());
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (String permissionCode : permissionCodess) {
//            if (permissionCode != null && permissionCode != "") {
//                GrantedAuthority grantedAuthority =
//                        new SimpleGrantedAuthority(permissionCode);
//                authorities.add(grantedAuthority);
//            }
//        }
//        WeChatAuthenticationToken authenticationResult = new WeChatAuthenticationToken(openid, authorities);
//
//        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return WeChatAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
