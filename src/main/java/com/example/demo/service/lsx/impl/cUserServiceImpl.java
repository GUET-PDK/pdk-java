package com.example.demo.service.lsx.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Address;
import com.example.demo.entity.User;
import com.example.demo.mapper.cUserMapper;
import com.example.demo.service.lsx.cUserService;
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
