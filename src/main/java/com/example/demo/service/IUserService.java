package com.example.demo.service;

import com.example.demo.entity.User;

public interface IUserService {

    /**
     * 数据库中来增加新的用户，并且给这个用户添加角色
     * @param user
     * @return
     */
    boolean addNewUser(User user);
}
