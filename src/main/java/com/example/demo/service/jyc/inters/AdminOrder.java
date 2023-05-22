package com.example.demo.service.jyc.inters;


import com.example.demo.dto.OrderMessage;

import java.util.List;
import java.util.Map;

public interface AdminOrder {
    List<OrderMessage> getAllOrders();

    int deleteOrder(Integer orderId);

    Map<String,Integer> countOrders();
}
