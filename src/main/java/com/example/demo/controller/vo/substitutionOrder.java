package com.example.demo.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName substitutionOrder
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/5/20 18:46
 * @Version 1.0
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
public class substitutionOrder {
//    private int id;   用不到

    private String shippingAddress;
    private int orderId;

    private Date deliveryTime1;
    private Date deliveryTime2;
    private String pickupCode;

    private String remark;
    private String size;
    private int price;

}
