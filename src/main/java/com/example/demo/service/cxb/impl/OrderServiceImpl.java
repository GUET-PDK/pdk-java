package com.example.demo.service.cxb.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.entity.orderDetail.Sent;
import com.example.demo.entity.orderDetail.Substitution;
import com.example.demo.entity.orderDetail.Takeaway;
import com.example.demo.entity.orderDetail.UniversalService;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.service.cxb.IOrderService;
import com.example.demo.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    @Qualifier("orderMapper")
    OrderMapper orderMapper;

    @Override
    public List<OrderVo> getMyOrder(Integer orderStatus,String userId) {

       List<OrderVo> list= orderMapper.selectOrderVo(null,userId,orderStatus);

        return list;
    }

    @Override
    public List<OrderVo> getAllOrder(Integer orderType) {
       List<OrderVo> list= orderMapper.selectOrderVo(orderType,null,null);
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
       order.setOrderStatus(1);
       int i=orderMapper.updateById(order);
       if(i!=1){
           //todo 接单失败有问题
       }
       return true;

    }

    @Override
    public Object getOrderDetail(int orderId,String userId) {
        Map map=new HashMap();
        map.put("order_id",orderId);
        List<Order> list=orderMapper.selectByMap(map);
        if(list==null||list.size()==0){
            //todo 订单id查询不到订单，是异常
        }
        if(list.get(0).getOrderStatus()!=0
                &&
                (!list.get(0).getTakeUserId().equals(userId))){
            //todo 有异常，这个订单既不是未被接单状态，也不是被这个骑手接单
        }
        int orderType=list.get(0).getOrderType();

        if(orderType==0){
            Substitution substitution = orderMapper.selectSubstitution(orderId);
            substitution.setOrderType(orderType);
            substitution.setOrderId(list.get(0).getOrderId());
            return substitution;
        }else if(orderType==1){
            Sent sent = orderMapper.selectSent(orderId);
            sent.setOrderType(orderType);
            sent.setOrderId(list.get(0).getOrderId());
            return sent;
        }else if(orderType==2){
            Takeaway takeaway = orderMapper.selectTakeaway(orderId);
            takeaway.setOrderType(orderType);
            takeaway.setOrderId(list.get(0).getOrderId());
            return takeaway;
        }else{
            UniversalService universalService = orderMapper.selectUniversalService(orderId);
            universalService.setOrderType(orderType);
            universalService.setOrderId(list.get(0).getOrderId());
            return universalService;
        }
    }


}
