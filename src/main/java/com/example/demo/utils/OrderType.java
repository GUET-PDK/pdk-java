package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName OrderType
 * @Description TODO
 * @Author chao
 * @Date 2023/5/22
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("orderType")
public class OrderType {
    @Value("${orderStatus.orderSent}")
    int orderSent;
    @Value("${orderStatus.substitution}")
    int substitution;
    @Value("${orderStatus.takeAway}")
    int takeAway;
    @Value("${orderStatus.universal}")
    int universal;
}
