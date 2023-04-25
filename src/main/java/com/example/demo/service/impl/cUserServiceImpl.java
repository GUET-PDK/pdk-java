package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Address;
import com.example.demo.entity.User;
import com.example.demo.mapper.cUserMapper;
import com.example.demo.service.IUserService;
import com.example.demo.service.cUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName cUserServiceImpl
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/4/25 15:02
 * @Version 1.0
 **/
@Service
public class cUserServiceImpl implements cUserService {

    @Autowired
    cUserMapper userMapper;

    @Override
    public Address updateAddress(String userId, String address) {
        return userMapper.updateAddress(userId,address);
    }

    @Override
    public int update(User entity, Wrapper<User> updateWrapper) {
        return userMapper.update(entity,null);
    }
}
