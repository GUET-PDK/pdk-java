package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ctfliar
 * @Description TODO
 * @Author zero
 * @Date 2023/4/25 20:17
 * @Version 1.0
 **/
@Mapper
public interface cOrderMapper extends BaseMapper<Order> {



//    用户查询订单，条件为订单的状态
    @Override
    List<Order> selectList(Wrapper<Order> queryWrapper);


//<<<<<<< HEAD
//    @Select("select order_type,order_id from sys_order where user_id=#{userId} and order_status=#{orderStatus};")
//    List<List<Integer>> selectOrderIdAndOrder(String userId,Integer orderStatus);
//=======
    //@Select("select order_type,order_id from sys_order where user_id=#{userId} and order_status=#{orderStatus}")
    List<Map> selectOrderIdAndOrder(String userId,Integer orderStatus);
//>>>>>>> lsx

    Order selectOneById(Integer orderId,String userId);



   // @Select("select * from ${tableName} where order_id=#{orderId}")
    Map selectList(String tableName,Integer orderId);

    Map selectAllList(String tableName,String userId);

//    用户查询当前订单的状态，，参数为用户id
    int selectOrderStatus(int userId);

//    用户评论，，增添一条评论
    int appraise(Integer orderId,String comment,String userId,Integer grade);




    //发布订单，在对应的表里插入一条订单数据，并再执行下面的update方法，将状态设置为 0 发布,
    //在主订单表里面插一个订单，获取返回的orderId，，，，再在功能分类表里面插入


    //再主表插入订单，订单类型不一样，，order_type作为参数,,要插入四种类型不同的0，1，2，3，，返回orderId
    @Override
    int insert(Order entity);



    //插入四个类型不一样的具体表，




    void insertSubstitution(String shippingAddress,
                            int orderId,
                            String deliveryTime1,
                            String deliveryTime2,
                            String pickUpCode,   //，文件数组取件码截图,,服务器后面处理上传的图片然后返回来的图片的路径
                            String remark,
                            String courierSize,
                            int price);













//    将订单的状态修改   0   1   2  发布，接单，完成
    @Update("update sys_order set order_status = #{status} where user_id = #{userId} and order_id = #{orderId}")
    int updateOrderStatusByOrderId(Integer orderId,String userId,int status);



    //根据用户id查出，，用户发布的订单列表，求总数
    @Select("select * from sys_order where user_id = #{userId}")
    List<Order> selectOrderListForCount(String userId);




}
