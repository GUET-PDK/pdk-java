package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.demo.entity.Order;
import com.example.demo.mapper.cOrderMapper;
import com.example.demo.service.cAppraiseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName cAppraiseServiceImpl
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/4/25 21:02
 * @Version 1.0
 **/
public class cOrderServiceImpl implements cAppraiseService {


    @Autowired
    cOrderMapper orderMapper;


    @Override
    public List<Order> selectList(Wrapper<Order> queryWrapper) {
        return orderMapper.selectList(queryWrapper);
    }

    @Override
    public int insert(Order entity) {
        return orderMapper.insert(entity);
    }

    @Override
    public int selectOrderStatus(int userId) {
        return orderMapper.selectOrderStatus(userId);
    }

    @Override
    public int appraise(int orderId, String comment, int userId, int grade) {
        return orderMapper.appraise(orderId,comment,userId,grade);
    }
}
