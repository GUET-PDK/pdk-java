package com.example.demo.service.cxb;

import com.example.demo.entity.Order;
import com.example.demo.vo.OrderVo;

import java.util.List;

public interface IOrderService {
    /**
     * 查看自己接的订单
     * @param userId
     * @return
     */
    List<OrderVo> getMyOrder(Integer orderStatus,String userId);

    /**
     * 获取所有正在发布的订单
     * @return
     */
    List<OrderVo> getAllOrder(Integer orderTYpe);

    boolean confirmOrder(int orderId,String userId);

    Object getOrderDetail(int orderId,String userId);

    /**
     * 骑手获取自己接单的数量
     * @param userId
     * @return
     */
    int getOrderCountByUserId(String userId);

}
