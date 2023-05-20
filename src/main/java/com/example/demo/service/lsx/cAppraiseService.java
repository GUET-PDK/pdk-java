package com.example.demo.service.lsx;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Order;

import java.util.List;

/**
 * @ClassName ctfliar
 * @Description TODO
 * @Author zero
 * @Date 2023/4/25 20:53
 * @Version 1.0
 **/
public interface cAppraiseService {



    Order selectOneById(Integer OrderId,Integer userId);
    List<List<Integer>> selectOrderIdAndOrder(Integer userId,Integer orderStatus);
    List<Order> selectList(String tableName,Integer orderId);
    int insert(Order entity);
    int selectOrderStatus(int userId);
    int appraise(Integer orderId,String comment,int userId,Integer grade);
    int updateOrderStatusByOrderId(Integer orderId,int userId,int status);

    List<Order> selectOrderListForCount(int userId);




}
