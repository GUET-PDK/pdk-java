package com.example.demo.mapper;

import com.example.demo.dto.OrderMessage;
import com.example.demo.dto.OrderRemarkAndPrice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 管理员对于订单的相关操作对应的Mapper接口
 */
@Mapper
public interface AdminOrderMapper {
    List<OrderMessage> selectAllOrders();
    Integer selectOrderTypeById(Integer id);
    OrderRemarkAndPrice selectRemarkAndPriceFromSent(Integer orderId);
    OrderRemarkAndPrice selectRemarkAndPriceFromSubstitution(Integer orderId);
    OrderRemarkAndPrice selectRemarkAndPriceFromTakeAway(Integer orderId);
    OrderRemarkAndPrice selectRemarkAndPriceFromUniversal(Integer orderId);

    int deleteFromOrderById(Integer id);
    int deleteFromSentByOrderId(Integer order);
    int deleteFromSubstitutionByOrderId(Integer order);
    int deleteFromTakeAwayByOrderId(Integer order);
    int deleteFromUniversalByOrderId(Integer order);

    Integer countPostOrder();
    Integer countPickUpOrder();
    Integer countFinishOrder();


}
