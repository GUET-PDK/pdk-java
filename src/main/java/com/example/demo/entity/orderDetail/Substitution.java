package com.example.demo.entity.orderDetail;

import com.example.demo.entity.Order;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Substitution extends Order implements Serializable {
    String shippingAddress;

    Date deliveryTime1;
    Date deliveryTime2;
    String pickupCode;
    String remark;
    String courierSize;
    int price;
}
