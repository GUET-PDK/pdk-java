package com.example.demo.entity.orderDetail;

import com.example.demo.entity.Order;
import lombok.Data;

import java.io.Serializable;

@Data
public class Takeaway  extends Order implements Serializable {
    String shippingAddress;
    String pickUpPosition;
    String remark;
    int price;
}
