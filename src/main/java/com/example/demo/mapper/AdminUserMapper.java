package com.example.demo.mapper;

import org.apache.ibatis.annotations.Param;

import java.sql.Date;

/**
 * @ClassName AdminAboveUserMapper
 * @Description 管理员端对于用户后端数据库的相关查询接口
 * @Author chao
 * @Date 2023/5/18
 * @Version 1.0
 **/
public interface AdminUserMapper {

    Integer countUser();

    Integer countDayToDay(@Param("start") Date start, @Param("end") Date end);


}
