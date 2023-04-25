package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Address;
import com.example.demo.entity.User;
import com.example.demo.mapper.cUserMapper;

/**
 * @ClassName ctfliar
 * @Description TODO
 * @Author zero
 * @Date 2023/4/25 15:02
 * @Version 1.0
 **/
public interface cUserService {


    Address updateAddress(String userId, String address);


    int update(User entity, Wrapper<User> updateWrapper);


}
