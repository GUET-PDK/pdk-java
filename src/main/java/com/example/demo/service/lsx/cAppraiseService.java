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


    List<Order> selectList(Wrapper<Order> queryWrapper);
    int insert(Order entity);
    int selectOrderStatus(int userId);
    int appraise(int orderId,String comment,int userId,int grade);


}
