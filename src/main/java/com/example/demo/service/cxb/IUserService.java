package com.example.demo.service.cxb;

import com.example.demo.entity.User;

public interface IUserService {

    /**
     * 数据库中来增加新的用户，并且给这个用户添加角色
     * @param user
     * @return
     */
    boolean addNewUser(User user);

    boolean revocation(String userId);


    /**
     * 发送验证码
     * @param phone
     * @return
     */
    boolean sentCode(String phone) throws Exception;

}
