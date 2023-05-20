package com.example.demo.utils;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @ClassName SqlDateLastWeekListUtil
 * @Description 获取上一周每一天的日期以及本周周一的日期
 *              下标 0-7 分别代表
 *                  上周一 上周二 上周三 上周四 上周五 上周六 上周日 本周一
 * @Author chao
 * @Date 2023/5/20
 * @Version 1.0
 **/
public class SqlDateLastWeekListUtil {
    public static ArrayList<Date> lastWeek(){
        ArrayList<Date> dates = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate lastWeekNow = now.minusDays(7);
        dates.add(Date.valueOf(lastWeekNow.with(DayOfWeek.MONDAY)));
        dates.add(Date.valueOf(lastWeekNow.with(DayOfWeek.TUESDAY)));
        dates.add(Date.valueOf(lastWeekNow.with(DayOfWeek.WEDNESDAY)));
        dates.add(Date.valueOf(lastWeekNow.with(DayOfWeek.THURSDAY)));
        dates.add(Date.valueOf(lastWeekNow.with(DayOfWeek.FRIDAY)));
        dates.add(Date.valueOf(lastWeekNow.with(DayOfWeek.SATURDAY)));
        dates.add(Date.valueOf(lastWeekNow.with(DayOfWeek.SUNDAY)));
        dates.add(Date.valueOf(now.with(DayOfWeek.MONDAY)));


        return dates;
    }
}
