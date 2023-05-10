package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Order;
import com.example.demo.entity.orderDetail.Sent;
import com.example.demo.entity.orderDetail.Substitution;
import com.example.demo.entity.orderDetail.Takeaway;
import com.example.demo.entity.orderDetail.UniversalService;
import com.example.demo.vo.OrderVo;

import java.util.List;


public interface OrderMapper extends BaseMapper<Order> {

    List<OrderVo> selectOrderVo(Integer orderType,String userId,Integer orderStatus);
    Sent selectSent(int orderId);
    Takeaway selectTakeaway(int orderId);
    UniversalService selectUniversalService(int orderId);
    Substitution selectSubstitution(int orderId);
}
