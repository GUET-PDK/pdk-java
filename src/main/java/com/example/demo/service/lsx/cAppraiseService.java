package com.example.demo.service.lsx;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.controller.vo.SentPublishOrder;
import com.example.demo.controller.vo.TakeAwayOrder;
import com.example.demo.controller.vo.UniversalOrder;
import com.example.demo.entity.Order;
import com.example.demo.mapper.TakeAwayMapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ctfliar
 * @Description TODO
 * @Author zero
 * @Date 2023/4/25 20:53
 * @Version 1.0
 **/
public interface cAppraiseService {



    Order selectOneById(Integer OrderId,Integer userId);
    List<Map> selectOrderIdAndOrder(String userId, Integer orderStatus);
    Map selectList(String tableName,Integer orderId);
    int insert(Order entity);
    int selectOrderStatus(int userId);
    int appraise(Integer orderId,String comment,int userId,Integer grade);
    int updateOrderStatusByOrderId(Integer orderId,int userId,int status);

    List<Order> selectOrderListForCount(int userId);


    int insertSubstitution(String shippingAddress,
                           String deliveryTime1,
                           String deliveryTime2,
                           String remark,
                           String pickUpCode,   //，文件数组取件码截图,,服务器后面处理上传的图片然后返回来的图片的路径
                           int price,
                           String courierSize,
                           int orderId);


    int insertUniversalOrder(UniversalOrder universalOrder);
    int insertSentOrder(SentPublishOrder sentPublishOrder);
    int insertTakeAwayOrder(TakeAwayOrder takeAwayOrder);



}
