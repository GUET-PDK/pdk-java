package com.example.demo.controller.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName SentPublishOrder
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/5/21 21:10
 * @Version 1.0
 **/


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_order_sent")
public class SentPublishOrder {
    @TableId("id")
    private int id;

    private int orderId;
    private String shippingAddress;
    private String recipientAddress;
    private String type;
    private String remark;
    private String courierSize;
    private int price;
}
