package com.example.demo.service.jyc.inters;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;
@Mapper
public interface AdminUser {

    Integer countUser();

    ArrayList<Integer> getActiveUserNum();

    List<User> getAllUsers();

    int banUser(String userId,int status);

    int pinUser(String userId, int status);
}
