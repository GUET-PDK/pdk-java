package com.example.demo.entity.orderDetail;

import com.example.demo.entity.Order;

import java.io.Serializable;

public class Takeaway  extends Order implements Serializable {
    String shippingAddress;
    String pickUpPosition;
    String remark;
    int price;
}
