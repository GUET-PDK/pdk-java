package com.example.demo.controller.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UniversalOrder
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/5/21 21:39
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_order_universal_service")
public class UniversalOrder {
    @TableId("id")
    private int id;
    private int order_id;
    private  String serviceDescription;
    private int price;
    private String remark;
    private String shippingAddress;
}
