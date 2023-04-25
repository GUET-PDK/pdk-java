package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Apply
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/4/25 17:07
 * @Version 1.0
 **/


@Data
@NoArgsConstructor
public class Apply {

    int id;
    int userId;
    int cardNumber;
    int idNumber;
    String idImage;
    String cardImage;

}
