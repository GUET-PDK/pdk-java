package com.example.demo.service.jyc.impls;

import com.example.demo.dto.ApplyMessage;
import com.example.demo.entity.User;
import com.example.demo.mapper.AdminRunnerMapper;
import com.example.demo.service.jyc.inters.AdminRunner;
import com.example.demo.utils.SqlDateLastWeekListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String,Integer> countApplication() {
        HashMap<String, Integer> map = new HashMap<>();
        // 0--未处理  1--同意  2--不同意
        map.put("allow",adminRunnerMapper.countApplicationByStatus(1));
        map.put("disAllow",adminRunnerMapper.countApplicationByStatus(2));
        map.put("notProcessed",adminRunnerMapper.countApplicationByStatus(0));
        return map;
    }

    @Override
    public ApplyMessage getRunnerApplyMessage(String id) {
//        System.out.println(id);
//        System.out.println(applyMessage);
        return adminRunnerMapper.selectApplyById(id);
    }

    /**
     * 通过管理员的骑手申请步骤：
     *      申请表申请记录的状态改为通过
     *      用户角色表通过用户id插入角色属性
     * @param id 用户id
     * @return 影响的记录条数
     */
    @Override
    @Transactional
    public int allowRunner(Integer id) {
        //申请表状态改为1，表示同意
        int i1 = adminRunnerMapper.updateApplyStatus(id, 1);
        //申请表查出该用户的用户名
        String userId = adminRunnerMapper.selectUserIdById(id);
        //通过用户名在sys_user表去查询用户信息，返回User对象
        User user = adminRunnerMapper.selectUserByUserId(userId);

        //获取当前时间作为更新时间,并转换成数据库的Date类型
        Date nowTime = Date.valueOf(LocalDate.now());

        Map<String,Object> map =new HashMap<>();
        map.put("userId",userId);
        map.put("createTime", user.getCreateTime());
        map.put("updateTime",nowTime);
        map.put("roleId",3);

        //用户角色中间表新增记录
        int i2 = adminRunnerMapper.insertUserRole(map);
//        int i2 = adminRunnerMapper.updateRoleIdByUserId(adminRunnerMapper.selectUserIdById(id));
        if ((i1+i2)==2) {
            return i1 + i2;
        }
        return 0;
    }

    @Override
    public int disAgreeRunner(Integer id) {
        int i = adminRunnerMapper.updateApplyStatus(id, 2);
        if (i==1) {
            return i;
        }
        return 0;
    }

    @Override
    public List<ApplyMessage> getApplyList() {
        List<ApplyMessage> list = new ArrayList<>();
        adminRunnerMapper.selectAllApply();
        return null;
    }
}
