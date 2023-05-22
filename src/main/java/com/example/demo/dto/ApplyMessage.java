package com.example.demo.dto;

import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * @ClassName ApplyMessage
 * @Description TODO
 * @Author chao
 * @Date 2023/5/21
 * @Version 1.0
 **/
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ApplyMessage {
    private int id;
    private int userId;
    private int idNumber;
    private int cardNumber;
    private String idImage;
    private String cardImage;
    private Date applyTime;
}
