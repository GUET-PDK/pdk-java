package com.example.demo.service.jyc.impls;

import com.example.demo.entity.User;
import com.example.demo.mapper.AdminUserMapper;
import com.example.demo.service.jyc.inters.AdminUser;
import com.example.demo.utils.SqlDateLastWeekListUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AdminServiceImpl
 * @Description
 * @Author chao
 * @Date 2023/5/3
 * @Version 1.0
 **/
@Service("adminUser")
public class AdminUserImpl implements AdminUser {
    @Resource
    AdminUserMapper adminUserMapper;

    @Override
    public Integer countUser() {
        return adminUserMapper.countUser();
    }


    @Override
    public ArrayList<Integer> getActiveUserNum() {

        ArrayList<Integer> activeUserNum = new ArrayList<>();

        //获取上一周到本周一每天的00:00
        ArrayList<Date> dates = SqlDateLastWeekListUtil.lastWeek();

        Integer lastMondayNum = adminUserMapper.countDayToDay(dates.get(0), dates.get(1));
        Integer lastTuesdayNum = adminUserMapper.countDayToDay(dates.get(1), dates.get(2));
        Integer lastWednesdayNum = adminUserMapper.countDayToDay(dates.get(2), dates.get(3));
        Integer lastThursdayNum = adminUserMapper.countDayToDay(dates.get(3), dates.get(4));
        Integer lastFridayNum = adminUserMapper.countDayToDay(dates.get(4), dates.get(5));
        Integer lastSaturdayNum = adminUserMapper.countDayToDay(dates.get(5), dates.get(6));
        Integer lastSundayNum = adminUserMapper.countDayToDay(dates.get(6), dates.get(7));

        activeUserNum.add(lastMondayNum);
        activeUserNum.add(lastTuesdayNum);
        activeUserNum.add(lastWednesdayNum);
        activeUserNum.add(lastThursdayNum);
        activeUserNum.add(lastFridayNum);
        activeUserNum.add(lastSaturdayNum);
        activeUserNum.add(lastSundayNum);

        return activeUserNum;
    }

    @Override
    public List<User> getAllUsers() {
        return adminUserMapper.selectAllUsers();
    }

    @Override
    public int banUser(String userId,int status){
//        return adminUserMapper.updateUserStatus(userId,status);
        if (adminUserMapper.updateUserStatus(userId,status)==1) {
            return adminUserMapper.updateUserStatus(userId,status);
        } else if(adminUserMapper.selectUserById(userId)==null){
            throw new RuntimeException("用户不存在");
        } else if(adminUserMapper.updateUserStatus(userId,status)==0){
            throw new RuntimeException("该用户已冻结");
        } else {
            throw new RuntimeException("用户状态更新超时");
        }
    }

    @Override
    public int pinUser(String userId, int status) {
        if (adminUserMapper.updateUserStatus(userId,status)==1) {
            return adminUserMapper.updateUserStatus(userId,status);
        } else if(adminUserMapper.selectUserById(userId)==null){
            throw new RuntimeException("用户不存在");
        } else if(adminUserMapper.updateUserStatus(userId,status)==0){
            throw new RuntimeException("该用户未被冻结");
        } else {
            throw new RuntimeException("用户状态更新超时");
        }
    }
}
