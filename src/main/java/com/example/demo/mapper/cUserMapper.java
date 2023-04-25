package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Address;
import com.example.demo.entity.Apply;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName ctfliar
 * @Description TODO
 * @Author zero
 * @Date 2023/4/25 14:57
 * @Version 1.0
 **/
@Mapper
public interface cUserMapper extends BaseMapper<User> {


    Address updateAddress(String userId,String address);






}
