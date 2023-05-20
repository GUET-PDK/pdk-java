package com.example.demo.service.jyc.impls;

import com.example.demo.mapper.AdminRunnerMapper;
import com.example.demo.service.jyc.inters.AdminRunner;
import com.example.demo.utils.SqlDateLastWeekListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;

/**
 * @ClassName AdminRunnerImpl
 * @Description TODO
 * @Author chao
 * @Date 2023/5/18
 * @Version 1.0
 **/
@Service("adminRunner")
public class AdminRunnerImpl implements AdminRunner {

    @Resource
    AdminRunnerMapper adminRunnerMapper;

    @Override
    public Integer countRunner() {
        return adminRunnerMapper.countRunner();
    }

    @Override
    public ArrayList<Integer> getActiveRunnerNum() {

        ArrayList<Integer> activeRunnerNum = new ArrayList<>();

        ArrayList<Date> dates = SqlDateLastWeekListUtil.lastWeek();

        Integer lastMondayNum = adminRunnerMapper.countDayToDay(dates.get(0), dates.get(1));
        Integer lastTuesdayNum = adminRunnerMapper.countDayToDay(dates.get(1), dates.get(2));
        Integer lastWednesdayNum = adminRunnerMapper.countDayToDay(dates.get(2), dates.get(3));
        Integer lastThursdayNum = adminRunnerMapper.countDayToDay(dates.get(3), dates.get(4));
        Integer lastFridayNum = adminRunnerMapper.countDayToDay(dates.get(4), dates.get(5));
        Integer lastSaturdayNum = adminRunnerMapper.countDayToDay(dates.get(5), dates.get(6));
        Integer lastSundayNum = adminRunnerMapper.countDayToDay(dates.get(6), dates.get(7));

        activeRunnerNum.add(lastMondayNum);
        activeRunnerNum.add(lastTuesdayNum);
        activeRunnerNum.add(lastWednesdayNum);
        activeRunnerNum.add(lastThursdayNum);
        activeRunnerNum.add(lastFridayNum);
        activeRunnerNum.add(lastSaturdayNum);
        activeRunnerNum.add(lastSundayNum);

        return activeRunnerNum;
    }
}
