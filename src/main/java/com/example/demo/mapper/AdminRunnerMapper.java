package com.example.demo.mapper;

import com.example.demo.dto.ApplyMessage;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface AdminRunnerMapper {
    Integer countRunner();

    Integer countDayToDay(@Param("start") Date start, @Param("end") Date end);

    Integer countApplicationByStatus(@Param("status") Integer status);

    ApplyMessage selectApplyById(@Param("id") String id);

    int updateApplyStatus(@Param("id")Integer id,@Param("status")Integer status);

    String selectUserIdById(@Param("id")Integer id);

    int updateRoleIdByUserId(@Param("userId")String userId);

    List<ApplyMessage> selectAllApply();

    User selectUserByUserId(String userId);

    int insertUserRole(Map<String, Object> map);

}
