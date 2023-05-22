package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @ClassName Order
 * @Description TODO
 * @Author chao
 * @Date 2023/5/22
 * @Version 1.0
 **/
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class OrderMessage {
    private Integer orderId;
    private String userId;
    private String takeUserId;
    private Integer orderType;
    private Integer orderStatus;
    private String createTime;
    private String updateTime;
    private String remark = "";
    private Integer price = 0;
}
