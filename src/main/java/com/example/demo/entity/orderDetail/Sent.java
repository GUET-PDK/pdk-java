package com.example.demo.entity.orderDetail;

import com.example.demo.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class Sent extends Order implements Serializable {
    String shippingAddress;
    String recipientAddress;
    String  type;
    String remark;
    String courierSize;
    int price;

}
