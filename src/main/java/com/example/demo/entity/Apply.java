package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;

/**
 * @ClassName Apply
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/4/25 17:07
 * @Version 1.0
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_apply_runner")
public class Apply implements Serializable {

    @TableId("id")
    int id;
    String userId;
    int cardNumber;
    int idNumber;
    String idImage;
    String cardImage;
    public Apply(String userId, int cardNumber, int idNumber, String idImage, String cardImage) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.idNumber = idNumber;
        this.idImage = idImage;
        this.cardImage = cardImage;
    }
}
