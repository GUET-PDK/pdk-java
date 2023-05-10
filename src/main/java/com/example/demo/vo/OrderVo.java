package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVo implements Serializable {
    int orderId;
    String shippingAddress;
    int price;
    String remark;
    int orderType;
}
