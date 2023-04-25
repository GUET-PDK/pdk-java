package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Address;
import com.example.demo.entity.Apply;
import com.example.demo.entity.User;
import com.example.demo.mapper.cUserMapper;
import com.example.demo.service.IUserService;
import com.example.demo.service.cUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName cUserServiceImpl
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/4/25 15:02
 * @Version 1.0
 **/
@Service
public class cUserServiceImpl extends ServiceImpl<cUserMapper,User> implements cUserService {

    @Autowired
    cUserMapper userMapper;

    @Override
    public Address updateAddress(String userId, String address) {
        return userMapper.updateAddress(userId,address);
    }

    @Override
    public boolean updateById(User entity) {
        return super.updateById(entity);
    }


}
