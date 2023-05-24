package com.example.demo.service.lsx.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Address;
import com.example.demo.entity.User;
import com.example.demo.mapper.cUserMapper;
import com.example.demo.service.lsx.cUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName cUserServiceImpl
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/4/25 15:02
 * @Version 1.0
 **/
@Service
public class cUserServiceImpl extends ServiceImpl<cUserMapper,User> implements cUserService {
    @Override
    public void upImage(String userId, String imageUrl) {
        userMapper.upImage(userId,imageUrl);
    }

    @Autowired
    cUserMapper userMapper;

    @Override
    public void updateAddress(String userId, String address,String addressPhone,String addressName) {

        userMapper.updateAddress(userId,address,addressPhone,addressName);
    }


    @Override
    public int MyUpdateById(User entity) {
        return userMapper.updateById(entity);
    }

    @Override
    public void deleteAddress(String addressId, String userId) {
        userMapper.deleteAddress(addressId,userId);
    }

    @Override
    public String selecetOpenId(String userId) {
        return userMapper.selectOpenId(userId);
    }

    @Override
    public List<Address> selectAddressListByUserId(String userId) {
        return userMapper.selectAddressListByUserId(userId);
    }

    @Override
    public User selectMessageById(String userId) {
        return userMapper.selectMessageById(userId);
    }
}
