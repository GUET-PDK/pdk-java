package com.example.demo.controller.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName TakeAwayOrder
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/5/21 21:34
 * @Version 1.0
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_order_takeaway")
public class TakeAwayOrder {
    @TableId("id")
    private int id;
    private int orderId;
    private String shippingAddress;
    private String pickUpPosition;
    private String remark;
    private int price;

}
