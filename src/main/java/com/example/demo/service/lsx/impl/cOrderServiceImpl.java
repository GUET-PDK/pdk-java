package com.example.demo.service.lsx.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.demo.entity.Order;
import com.example.demo.mapper.cOrderMapper;
import com.example.demo.service.lsx.cAppraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName cAppraiseServiceImpl
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/4/25 21:02
 * @Version 1.0
 **/
@Service
public class cOrderServiceImpl implements cAppraiseService {


    @Autowired
    cOrderMapper orderMapper;


    @Override
    public Order selectOneById(Integer orderId,Integer userId) {
        return orderMapper.selectOneById(orderId,userId);
    }

    @Override
    public List<List<Integer>> selectOrderIdAndOrder(Integer userId, Integer orderStatus) {
        return orderMapper.selectOrderIdAndOrder(userId,orderStatus);
    }

    @Override
    public List<Order> selectList(String tableName, Integer orderId) {
        return orderMapper.selectList(tableName,orderId);
    }



    @Override
    public int selectOrderStatus(int userId) {
        return orderMapper.selectOrderStatus(userId);
    }

    @Override
    public int appraise(Integer orderId, String comment, int userId, Integer grade) {
        return orderMapper.appraise(orderId,comment,userId,grade);
    }

    @Override
    public int updateOrderStatusByOrderId(Integer orderId, int userId,int status) {
        return orderMapper.updateOrderStatusByOrderId(orderId,userId,status);
    }

    @Override
    public List<Order> selectOrderListForCount(int userId) {
        return orderMapper.selectOrderListForCount(userId);
    }



    //插入不同的四个类型的订单
    @Override
    public int insert(Order entity) {
        return orderMapper.insert(entity);
    }




}
