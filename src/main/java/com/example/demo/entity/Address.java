package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_address")
public class Address implements Serializable {
    @TableId(value = "address_id",type = IdType.AUTO)
    private int addressId;
    private String addressDescription;
    private String addressName;
    private String userId;
    private String addressPhone;
}
