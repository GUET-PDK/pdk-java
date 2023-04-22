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

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("sys_user")
public class User implements Serializable {
    private String userName;
    private String userPhone;

    @TableId(value = "user_id")
    private String userId;
    private String userAvatar;
    private int status;
    private Date createTime;
    private Date updateTime;
    private String openId;
}
