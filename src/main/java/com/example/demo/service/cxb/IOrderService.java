package com.example.demo.service.cxb;

import com.example.demo.entity.Order;

import java.util.List;

public interface IOrderService {
    /**
     * 查看自己以往完成的历史订单
     * @param userId
     * @return
     */
    List<Order> getMyOrder(String userId);

    /**
     * 获取所有正在发布的订单
     * @return
     */
    List<Order> getAllOrder();

    boolean confirmOrder(int orderId,String userId);
}
