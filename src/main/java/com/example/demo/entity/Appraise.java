package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_appraise")
public class Appraise implements Serializable {
    @TableId(value = "appraise_id",type = IdType.AUTO)
    private int appraiseId;
    private String appraiseDescription;
    private int appraiseFraction;
    private int orderId;
    private String userId;
}
