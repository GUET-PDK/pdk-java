package com.example.demo.service.cxb.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.cxb.IUserService;
import com.example.demo.utils.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean addNewUser(User user) {
       int a= userMapper.insert(user);
      int roleId= userMapper.selectRoleIdByRoleName(RoleEnum.普通用户.name());
       int b= userMapper.insertMiddleUserRole(user.getUserId(), roleId);
       if(a+b==2)
        return true;
       else return false;
    }

    @Override
    public boolean revocation(String userId) {

       Integer id= userMapper.selectMiddleIdByUserId(userId);
       if(id==null){
           //todo 异常
       }
      int i =userMapper.deleteMiddleRoleById(id);
       if(i==0){
           //todo 异常
       }
        return true;
    }

}
