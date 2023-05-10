package com.example.demo.entity.orderDetail;

import com.example.demo.entity.Order;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

public class Substitution extends Order implements Serializable {
    String shippingAddress;
    Date deliverTime1;
    Date deliverTime2;
    String pickupCode;
    String remark;
    String courierSize;
    int price;
}
