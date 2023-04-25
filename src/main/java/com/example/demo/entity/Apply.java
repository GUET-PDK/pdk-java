package com.example.demo.entity;

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
public class Apply implements Serializable {

    int id;
    int userId;
    int cardNumber;
    int idNumber;
    String idImage;
    String cardImage;
    public Apply(int userId, int cardNumber, int idNumber, String idImage, String cardImage) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.idNumber = idNumber;
        this.idImage = idImage;
        this.cardImage = cardImage;
    }
}
