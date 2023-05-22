package com.example.demo.service.jyc.impls;
import com.example.demo.controller.back.myException.OrderNotMatchException;
import com.example.demo.dto.OrderMessage;
import com.example.demo.dto.OrderRemarkAndPrice;
import com.example.demo.mapper.AdminOrderMapper;
import com.example.demo.service.jyc.inters.AdminOrder;
import com.example.demo.utils.OrderType;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AdminOrderImpl
 * @Description TODO
 * @Author chao
 * @Date 2023/5/18
 * @Version 1.0
 **/
@Service("adminOrder")
public class AdminOrderImpl implements AdminOrder {

    @Resource
    private AdminOrderMapper adminOrderMapper;
    @Resource(name = "orderType")
    OrderType orderType;
    @Override
    public List<OrderMessage> getAllOrders() throws RuntimeException{
        List<OrderMessage> orderMessages = adminOrderMapper.selectAllOrders();

        Integer orderSent = orderType.getOrderSent();
        Integer substitution = orderType.getSubstitution();
        Integer takeAway = orderType.getTakeAway();
        Integer universal = orderType.getUniversal();

        orderMessages.forEach(orderMessage -> {
            System.out.println(orderMessage.getOrderType());
            System.out.println(orderMessage.getOrderId());
            if (orderSent.equals(orderMessage.getOrderType())) {
                OrderRemarkAndPrice orap = adminOrderMapper.selectRemarkAndPriceFromSent(orderMessage.getOrderId());
                if (orap!=null) {
                    orderMessage.setRemark(orap.getRemark());
                    orderMessage.setPrice(orap.getPrice());
                } else {
                    throw new OrderNotMatchException("订单发布后另一个表没更新啊蠢蛋用户端开发人员");
                }
            } else if (substitution.equals(orderMessage.getOrderType())) {
                OrderRemarkAndPrice orap = adminOrderMapper.selectRemarkAndPriceFromSubstitution(orderMessage.getOrderId());
                if (orap!=null) {
                    orderMessage.setRemark(orap.getRemark());
                    orderMessage.setPrice(orap.getPrice());
                } else {
                    throw new OrderNotMatchException("订单发布后另一个表没更新啊蠢蛋用户端开发人员");
                }
            } else if (takeAway.equals(orderMessage.getOrderType())) {
                OrderRemarkAndPrice orap = adminOrderMapper.selectRemarkAndPriceFromTakeAway(orderMessage.getOrderId());
                if (orap!=null) {
                    orderMessage.setRemark(orap.getRemark());
                    orderMessage.setPrice(orap.getPrice());
                } else {
                    throw new OrderNotMatchException("订单发布后另一个表没更新啊蠢蛋用户端开发人员");
                }
            } else if (universal.equals(orderMessage.getOrderType())) {
                OrderRemarkAndPrice orap = adminOrderMapper.selectRemarkAndPriceFromUniversal(orderMessage.getOrderId());
                if (orap!=null) {
                    orderMessage.setRemark(orap.getRemark());
                    orderMessage.setPrice(orap.getPrice());
                } else {
                    throw new OrderNotMatchException("订单发布后另一个表没更新啊蠢蛋用户端开发人员");
                }
            } else {
                throw new OrderNotMatchException("订单类型异常，该订单类型未定义");
            }
        });
        return orderMessages;
    }

    @Override
    public int deleteOrder(Integer orderId) throws RuntimeException{
        int type = adminOrderMapper.selectOrderTypeById(orderId);
        int nums = adminOrderMapper.deleteFromOrderById(orderId);
        //删除订单表数据
        if (nums==0) {
            throw new RuntimeException("该订单不存在或已经删除，干点别的吧亲");
        }
        //根据订单类型删除对应表中的订单信息
        if (type==orderType.getOrderSent()) {
            int i = adminOrderMapper.deleteFromSentByOrderId(orderId);
            if (i == 1) {
                return i + nums;
            } else if (i == 0) {
                throw new RuntimeException("订单删除错误，该类型订单未存储到对应的表中，扑该");
            }
        } else if (type==orderType.getSubstitution()) {
            int i = adminOrderMapper.deleteFromSubstitutionByOrderId(orderId);
            if (i == 1) {
                return i + nums;
            } else if (i == 0) {
                throw new RuntimeException("订单删除错误，该类型订单未存储到对应的表中，扑该");
            }
        } else if (type==orderType.getTakeAway()) {
            int i = adminOrderMapper.deleteFromTakeAwayByOrderId(orderId);
            if (i == 1) {
                return i + nums;
            } else if (i == 0) {
                throw new RuntimeException("订单删除错误，该类型订单未存储到对应的表中，扑该");
            }
        } else if (type==orderType.getUniversal()) {
            int i = adminOrderMapper.deleteFromUniversalByOrderId(orderId);
            if (i == 1) {
                return i + nums;
            } else if (i == 0) {
                throw new RuntimeException("订单删除错误，该类型订单未存储到对应的表中，扑该");
            }
        } else {
            throw new RuntimeException("订单类型异常，该订单类型未定义");
        }
        return 0;
    }

    @Override
    public Map<String, Integer> countOrders() {
        Map<String, Integer> map = new HashMap<>();
        map.put("postOrder",adminOrderMapper.countPostOrder());
        map.put("pickUpOrder",adminOrderMapper.countPickUpOrder());
        map.put("finishOrder",adminOrderMapper.countFinishOrder());
        return map;
    }
}
