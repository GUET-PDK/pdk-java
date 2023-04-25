package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName ctfliar
 * @Description TODO
 * @Author zero
 * @Date 2023/4/25 20:17
 * @Version 1.0
 **/
@Mapper
public interface cOrderMapper extends BaseMapper<Order> {



//    用户查询历史订单，，，，条件为订单的状态
    @Override
    List<Order> selectList(Wrapper<Order> queryWrapper);



//发布订单，插入一条订单数据，并将状态设置为  发布,,,返回orderId当作订单编号
    @Override
    int insert(Order entity);


//    用户查询当前订单的状态，，参数为用户id
    int selectOrderStatus(int userId);

//    用户评论，，增添一条评论
    int appraise(int orderId,String comment,int userId,int grade);

}
