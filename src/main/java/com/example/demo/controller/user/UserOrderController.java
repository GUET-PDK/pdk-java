package com.example.demo.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.controller.vo.SentPublishOrder;
import com.example.demo.controller.vo.TakeAwayOrder;
import com.example.demo.controller.vo.UniversalOrder;
import com.example.demo.controller.vo.substitutionOrder;
import com.example.demo.entity.Order;
import com.example.demo.service.lsx.impl.cOrderServiceImpl;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.RestResponse;
import com.example.demo.utils.upLoads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName UserOrderController
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/4/21 10:56
 * @Version 1.0
 **/
@RestController
@CrossOrigin(origins = "*")
public class UserOrderController extends BaseController{


    @Autowired
    private cOrderServiceImpl orderService;


    @Value("${orderType.publish}")
    private int publishStatus;
    @Value("${orderType.dispose}")
    private int disposeStatus;
    @Value("${orderType.finish}")
    private int finishStatus;


    @Value("${orderStatus.orderSent}")
    private int orderSentType;
    @Value("${orderStatus.substitution}")
    private int substitutionType;
    @Value("${orderStatus.takeAway}")
    private int takeAwayType;
    @Value("${orderStatus.universal}")
    private int universalType;

    @Value("${uploads.path}")
    private String upImagePath;

    @Value("${get.path}")
    private String getImagePath;


    /**
     * @Author ctfliar
     * @Description //用户查询不同装状态的订单
     * @Date 21:14 2023/4/25
     * @Param
     * @return
     * @return com.example.demo.utils.RestResponse
     **/
    @RequestMapping("/selectOrder")
    @PreAuthorize("hasAuthority('下订单')")
    public RestResponse selectOrder(HttpServletRequest request,Integer orderStatus)
    {

        String token=request.getHeader("token");
//        使用jwt的工具类，，拿到token里面的用户id
        JwtUtil jwt = new JwtUtil();
        String userId = (jwt.getClaim(token).get("userId").toString());
        //status分别表示未结单，配送中，已完成三种状态
        //示例值:
        //0或1或2


        try{

            //通过status，和userId找到orderType(对应不同的表)和orderId,返回的是一个列表
            List<Map> orderTypeAndOrderId = orderService.selectOrderIdAndOrder(userId,orderStatus);

            List<Object> list = new ArrayList<>();
            for(int i=0;i<orderTypeAndOrderId.size();i++)
            {
                //oderType,0,1,2,3对应下面四种类型的订单表,

                Map temp = orderTypeAndOrderId.get(i);
                Integer orderType = (Integer) temp.get("orderType");
                Integer orderId = (Integer)temp.get("orderId");


//                QueryWrapper<Order> qw = new QueryWrapper<Order>();
//                qw.eq("order_id",orderId);
                String tableName;
//                写一个判断，，，查出来的是什么数字的时候直接通过这样指定表名字，，然后进行直接判断
                if(orderType.equals(1))
                {
                     tableName = "sys_order_sent";
                }
                else if(orderType.equals(0))
                {
                     tableName = "sys_order_substitution";
                }
                else if(orderType.equals(2))
                {
                     tableName = "sys_order_takeaway";
                }
                else {
                     tableName = "sys_order_universal_service";
                }

               Map map= orderService.selectList(tableName,orderId);
                Map map1=new HashMap();
                map1.put("order_type",orderType);
                map1.put("orderId",orderId);
                map1.put("price",map.get("price"));
                map1.put("remark",map.get("remark"));
                list.add(map1);

            }

            return new RestResponse(200,"查询订单成功",list);
        }catch (RuntimeException e){
            e.printStackTrace();
        }

        return new RestResponse(200,"查询订单失败",null);

    };





    /**
     * @Author ctfliar
     * @Description //获取自己的某个订单的详细数据
     * @Date 11:06 2023/5/18
     * @Param
     * @param request
     * @param orderId
     * @return
     * @return com.example.demo.utils.RestResponse
     **/
    @RequestMapping("/getOrderDetail")
    @PreAuthorize("hasAuthority('下订单')")
    public RestResponse getOrderDetail(HttpServletRequest request,Integer orderId)
    {


        String token=request.getHeader("token");
//        使用jwt的工具类，，拿到token里面的用户id
        JwtUtil jwt = new JwtUtil();
        Integer userId = Integer.parseInt(jwt.getClaim(token).get("userId").toString());

        QueryWrapper<Order> qw = new QueryWrapper<Order>();
        qw.eq("user_id",userId);
        qw.eq("order_id",orderId);

        try {
            Order order = orderService.selectOneById(orderId,userId);
            return new RestResponse(200,"查询数据成功",order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    };





    /**
     * @Author ctfliar
     * @Description //用户点击完成订单并评论，
     * 用户点击这个来将配送中的订单变成已完成，同时并可以选择是否评价和打分，
     * 如果没有评价或者打分，那就由后端默认打分为8分
     * @Date 11:15 2023/5/18
     * @Param
     * @param request
     * @param orderId
     * @param comment
     * @param grade
     * @return
     * @return com.example.demo.utils.RestResponse
     **/
    @RequestMapping("/commentOrder")
    @PreAuthorize("hasAuthority('下订单')")
    public RestResponse commentOrder(HttpServletRequest request,Integer orderId,String comment,Integer grade)
    {

        String token = request.getHeader("token");
        JwtUtil jwt = new JwtUtil();
        int userId = Integer.parseInt(jwt.getClaim(token).get("userId").toString());



        //将订单状态变成完成,,定义订单完成的状态是2，，，，定义订单在执行中的状态是1，已经下单的状态是0
        int status = 2;
        orderService.updateOrderStatusByOrderId(orderId,userId,status);


//        用户是否评价和打分，没有评价或者打分的话，就系统默认
        if(grade==null){
            grade = 8;//默认八分
        }
        if(comment.equals(null)){
            comment="该用户暂时无评论";
        }

        try{
            orderService.appraise(orderId,comment,userId,grade);
            return new RestResponse(200,"评论成功",null);

      }catch (RuntimeException e){
            e.printStackTrace();
        }

        return new RestResponse(201,"评论失败",null);
    };




    @RequestMapping("/sentPublishOrder")
    @PreAuthorize("hasAuthority('下订单')")
    public RestResponse sentPublishOrder(
            String shippingAddress,
            String recipientAddress,
            String type,
            String remark,
            String courizer_size,
            Integer price,
            HttpServletRequest request
    ){

        //        使用jwt的工具类，，拿到token里面的用户id
        String token=request.getHeader("token");
        JwtUtil jwt = new JwtUtil();
        String userId = jwt.getClaim(token).get("userId").toString();


        //存入两个表,,一般订单表

        int orderType = orderSentType;
        int orderStatus = publishStatus;

        SimpleDateFormat formatter = new SimpleDateFormat("y-y-y-y-MM-dd HH:mm:ss");
        Date createTime = new Date(formatter.format(System.currentTimeMillis()));
        Date updateTime = createTime;

        Order order = new Order();
        order.setUserId(userId);
        order.setOrderStatus(orderStatus);
        order.setOrderType(orderType);
        order.setCreateTime(createTime);
        order.setUpdateTime(updateTime);


        try {
            int result = orderService.insert(order);
        } catch (Exception e) {
            return new RestResponse(200,"发布失败",e);

        }
        //插入数据，id自动递增，赋值
        int orderId = order.getOrderId();


        SentPublishOrder sentPublishOrder = new SentPublishOrder();
        sentPublishOrder.setOrderId(orderId);
        sentPublishOrder.setCourierSize(courizer_size);
        sentPublishOrder.setPrice(price);
        sentPublishOrder.setRemark(remark);
        sentPublishOrder.setRecipientAddress(recipientAddress);
        sentPublishOrder.setType(type);

        try {
            orderService.insertSentOrder(sentPublishOrder);
            return new RestResponse(200,"发布成功",null);
        } catch (Exception e) {
            return new RestResponse(200,"发布失败",e);
        }


    }



    /**
     * @Author ctfliar
     * @Description //TODO
     * @Date 20:36 2023/5/21
     * @Param
     * @param shippingAddress
     * @param deliveryTime1
     * @param deliveryTime2
     * @param remark
     * @param pickupCode
     * @param price
     * @param courierSize
     * @param request
     * @return
     * @return com.example.demo.utils.RestResponse
     **/
    @RequestMapping("/substitutionPublishOrder")
    @PreAuthorize("hasAuthority('下订单')")
    public RestResponse substitutionPublishOrder(
            String shippingAddress,
            String deliveryTime1,
            String deliveryTime2,
            String remark,
            MultipartFile pickupCode,   //，文件数组取件码截图  //默认情况是一张
            int price,
            String courierSize,
            HttpServletRequest request)
    {

//        使用jwt的工具类，，拿到token里面的用户id
        String token=request.getHeader("token");
        JwtUtil jwt = new JwtUtil();
        String userId = jwt.getClaim(token).get("userId").toString();


        //存入两个表,,一般订单表

        int orderType = substitutionType;
        int orderStatus = publishStatus;
        SimpleDateFormat formatter = new SimpleDateFormat("y-y-y-y-MM-dd HH:mm:ss");
        Date createTime = new Date(formatter.format(System.currentTimeMillis()));
        Date updateTime = createTime;

        Order order = new Order();
        order.setUserId(userId);
        order.setOrderStatus(orderStatus);
        order.setOrderType(orderType);
        order.setCreateTime(createTime);
        order.setUpdateTime(updateTime);


        int result = orderService.insert(order);
        //插入数据，id自动递增，赋值
        int orderId = order.getOrderId();





        String imagePath = new upLoads().upLoad(pickupCode,upImagePath,getImagePath);


        //获取返回之后的orderId之后插入第二张表
        //vo虚拟传输工具类


        try {
            orderService.insertSubstitution(
                    shippingAddress,
                    createTime.toString(),
                    updateTime.toString(),
                    remark,
                    courierSize,
                    price,
                    imagePath,
                    orderId);
            return new RestResponse(200,"发布成功",null);

        } catch (Exception e) {
            return new RestResponse(200,"发布失败",e);

        }

    };




    @RequestMapping("/takeawayPublishOrder")
    @PreAuthorize("hasAuthority('下订单')")
    public RestResponse takeawayPublishOrder(
            String shippingAddress,
            String pickUpPositon,
            String remark,
            Integer price,
            HttpServletRequest request
    ){

        //        使用jwt的工具类，，拿到token里面的用户id
        String token=request.getHeader("token");
        JwtUtil jwt = new JwtUtil();
        String userId = jwt.getClaim(token).get("userId").toString();


        //存入两个表,,一般订单表

        int orderType = takeAwayType;
        int orderStatus = publishStatus;


        SimpleDateFormat formatter = new SimpleDateFormat("y-y-y-y-MM-dd HH:mm:ss");
        Date createTime = new Date(formatter.format(System.currentTimeMillis()));
        Date updateTime = createTime;

        Order order = new Order();
        order.setUserId(userId);
        order.setOrderStatus(orderStatus);
        order.setOrderType(orderType);
        order.setCreateTime(createTime);
        order.setUpdateTime(updateTime);


        int result = orderService.insert(order);
        //插入数据，id自动递增，赋值
        int orderId = order.getOrderId();


        TakeAwayOrder takeAwayOrder = new TakeAwayOrder();
        takeAwayOrder.setOrderId(orderId);
        takeAwayOrder.setPrice(price);
        takeAwayOrder.setRemark(remark);
        takeAwayOrder.setShippingAddress(shippingAddress);
        takeAwayOrder.setPickUpPosition(pickUpPositon);
        try {
            orderService.insertTakeAwayOrder(takeAwayOrder);
            return new RestResponse(200,"发布成功",null);
        } catch (Exception e) {
            return new RestResponse(200,"发布失败",e);
        }

    }



    @RequestMapping("/universalServicePublishOrder")
    @PreAuthorize("hasAuthority('下订单')")
    public RestResponse universalServicePublishOrder(
            String serviceDescription,
            Integer price,
            String remark,
            HttpServletRequest request
    ){

        //        使用jwt的工具类，，拿到token里面的用户id
        String token=request.getHeader("token");
        JwtUtil jwt = new JwtUtil();
        String userId = jwt.getClaim(token).get("userId").toString();


        //存入两个表,,一般订单表

        int orderType = universalType;
        int orderStatus = publishStatus;


        SimpleDateFormat formatter = new SimpleDateFormat("y-y-y-y-MM-dd HH:mm:ss");
        Date createTime = new Date(formatter.format(System.currentTimeMillis()));
        Date updateTime = createTime;

        Order order = new Order();
        order.setUserId(userId);
        order.setOrderStatus(orderStatus);
        order.setOrderType(orderType);
        order.setCreateTime(createTime);
        order.setUpdateTime(updateTime);


        int result = orderService.insert(order);
        //插入数据，id自动递增，赋值
        int orderId = order.getOrderId();

        UniversalOrder universalOrder = new UniversalOrder();
        universalOrder.setOrder_id(orderId);
        universalOrder.setPrice(price);
        universalOrder.setRemark(remark);
        universalOrder.setServiceDescription(serviceDescription);

        try {
            orderService.insertUniversalOrder(universalOrder);
            return new RestResponse(200,"发布成功",null);
        } catch (Exception e) {
            return new RestResponse(200,"发布失败",e);
        }

    }








}
