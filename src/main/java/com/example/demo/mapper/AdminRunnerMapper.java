package com.example.demo.mapper;

import com.example.demo.dto.ApplyMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
@Mapper
public interface AdminRunnerMapper {
    Integer countRunner();

    Integer countDayToDay(@Param("start") Date start, @Param("end") Date end);

    Integer countApplicationByStatus(@Param("status") Integer status);

    ApplyMessage selectApplyByUserId(@Param("status") String userId);

    int updateApplyStatus(@Param("id")Integer id,@Param("status")Integer status);

    String selectUserIdById(@Param("id")Integer id);

    int updateRoleIdByUserId(@Param("userId")String userId);
}
