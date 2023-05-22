package com.example.demo.entity.orderDetail;

import com.example.demo.entity.Order;
import lombok.Data;

import java.io.Serializable;

@Data
public class UniversalService extends Order implements Serializable {
    String serviceDescription;
    int price;
    String remark;
    String shippingAddress;
}
