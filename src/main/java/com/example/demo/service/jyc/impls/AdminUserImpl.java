package com.example.demo.service.jyc.impls;

import com.example.demo.mapper.AdminUserMapper;
import com.example.demo.service.jyc.inters.AdminUser;
import com.example.demo.utils.SqlDateLastWeekListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @ClassName AdminServiceImpl
 * @Description
 * @Author chao
 * @Date 2023/5/3
 * @Version 1.0
 **/
@Service("adminService")
public class AdminUserImpl implements AdminUser {
    @Resource
    AdminUserMapper adminUserMapper;

    @Override
    public Integer countUser() {
        return adminUserMapper.countUser();
    }

    @Override
    public Integer countRunner() {
        return null;
    }

    @Override
    public ArrayList<Integer> getActiveUserNum() {

        ArrayList<Integer> activeUserNum = new ArrayList<>();

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
}
