package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_order")
public class Order implements Serializable {

    @TableId(value = "order_id",type = IdType.AUTO)
    private int orderId;
    private String userId;
    private String takeUserId;
    private int orderType;
    private int orderStatus;
    private Date createTime;
    private Date updateTime;
    private Date startTime;
    private Date finishTime;

    @TableField("address_1")
    private String address1;

    @TableField("address_2")
    private String address2;
    private String orderDescription;
}
