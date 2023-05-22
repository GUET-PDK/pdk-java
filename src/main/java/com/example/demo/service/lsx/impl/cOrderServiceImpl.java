package com.example.demo.service.lsx.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.demo.controller.vo.SentPublishOrder;
import com.example.demo.controller.vo.TakeAwayOrder;
import com.example.demo.controller.vo.UniversalOrder;
import com.example.demo.entity.Order;
import com.example.demo.mapper.SentPublishMapper;
import com.example.demo.mapper.TakeAwayMapper;
import com.example.demo.mapper.UniversalServiceMapper;
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

    @Autowired
    SentPublishMapper sentPublishMapper;

    @Autowired
    TakeAwayMapper takeAwayMapper;

    @Autowired
    UniversalServiceMapper universalServiceMapper;





    @Override
    public Order selectOneById(Integer OrderId, String userId) {
        return orderMapper.selectOneById(OrderId,userId);
    }

    @Override
    public List<List<Integer>> selectOrderIdAndOrder(String userId, Integer orderStatus) {
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
    public int appraise(Integer orderId, String comment, String userId, Integer grade) {
        return orderMapper.appraise(orderId,comment,userId,grade);
    }

    @Override
    public int updateOrderStatusByOrderId(Integer orderId, String userId,int status) {
        return orderMapper.updateOrderStatusByOrderId(orderId,userId,status);
    }

    @Override
    public List<Order> selectOrderListForCount(String userId) {
        return orderMapper.selectOrderListForCount(userId);
    }

    @Override
    public void insertSubstitution(String shippingAddress, String deliveryTime1, String deliveryTime2, String remark, String pickUpCode, int price, String courierSize, int orderId) {
        orderMapper.insertSubstitution(shippingAddress,orderId,deliveryTime1,deliveryTime2,pickUpCode,remark,courierSize,price);
    }

    @Override
    public int insertUniversalOrder(UniversalOrder universalOrder) {
        return universalServiceMapper.insert(universalOrder);
    }

    @Override
    public int insertSentOrder(SentPublishOrder sentPublishOrder) {
        return sentPublishMapper.insert(sentPublishOrder);
    }

    @Override
    public int insertTakeAwayOrder(TakeAwayOrder takeAwayOrder) {
        return takeAwayMapper.insert(takeAwayOrder);
    }


    //插入不同的四个类型的订单
    @Override
    public int insert(Order entity) {
        return orderMapper.insert(entity);
    }




}
