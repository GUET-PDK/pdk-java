package com.example.demo.entity.orderDetail;

import com.example.demo.entity.Order;

import java.io.Serializable;

public class UniversalService extends Order implements Serializable {
    String serviceDescription;
    int price;
    String remark;
    String shippingAddress;
}
