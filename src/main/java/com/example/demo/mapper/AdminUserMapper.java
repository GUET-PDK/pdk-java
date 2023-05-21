package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 * @ClassName AdminAboveUserMapper
 * @Description 管理员端对于用户后端数据库的相关查询接口
 * @Author chao
 * @Date 2023/5/18
 * @Version 1.0
 **/
@Mapper
public interface AdminUserMapper {

    Integer countUser();

    Integer countDayToDay(@Param("start") Date start, @Param("end") Date end);


    List<User> selectAllUsers();

    int updateUserStatus(@Param("userId") String userId,@Param("status") int status);

    User selectUserById(@Param("userId") String userId);

}
