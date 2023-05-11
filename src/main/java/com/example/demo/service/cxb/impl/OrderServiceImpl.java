package com.example.demo.service.cxb.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Order;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.service.cxb.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    @Qualifier("orderMapper")
    OrderMapper orderMapper;

    @Override
    public List<Order> getMyOrder(String userId) {
        Map<String,Object> map=new HashMap<>();
        map.put("user_id",userId);
        map.put("order_status",0);//todo 这里后面需要确定完成的订单的状态是什么
       List<Order> list= orderMapper.selectByMap(map);

        return list;
    }

    @Override
    public List<Order> getAllOrder() {
        Map<String,Object> map=new HashMap<>();

        map.put("order_status",1);//todo 这里后面需要确定完成的订单的状态是什么
        List<Order> list= orderMapper.selectByMap(map);
        return list;
    }

    @Override
    public boolean confirmOrder(int orderId, String userId) {
        Map<String,Object> map=new HashMap<>();
        map.put("order_id",orderId);
       List<Order> list= orderMapper.selectByMap(map);
       if(list==null||list.size()==0){
           //todo 订单id查询不到订单，是异常
       }
       Order order=list.get(0);
       if(order.getTakeUserId()!=null){
           //todo 订单已经被接取，有异常
       }
       if(order.getOrderStatus()!=0){
           //todo 订单的状态不是正在发布的状态
       }
       order.setTakeUserId(userId);
       order.setUpdateTime(new Date());
       int i=orderMapper.updateById(order);
       if(i!=1){
           //todo 接单失败有问题
       }
       return true;

    }
}
