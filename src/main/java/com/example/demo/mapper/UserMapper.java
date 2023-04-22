package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;

import java.util.List;
import java.util.Set;

public interface UserMapper extends BaseMapper<User> {

    Set<String> selectPermissionByUserId(String  userId);

    int insertMiddleUserRole(String userId,String roleName);
}