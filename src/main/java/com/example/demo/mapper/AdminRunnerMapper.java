package com.example.demo.mapper;

import org.apache.ibatis.annotations.Param;

import java.sql.Date;

public interface AdminRunnerMapper {
    Integer countRunner();

    Integer countDayToDay(@Param("start") Date start, @Param("end") Date end);
}
