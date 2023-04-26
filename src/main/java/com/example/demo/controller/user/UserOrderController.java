package com.example.demo.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Order;
import com.example.demo.service.lsx.impl.cOrderServiceImpl;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.RestResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName UserOrderController
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/4/21 10:56
 * @Version 1.0
 **/
@RestController
public class UserOrderController extends BaseController{


    private cOrderServiceImpl orderService;



    /**
     * @Author ctfliar
     * @Description //通过用户id查询历史订单
     * @Date 21:14 2023/4/25
     * @Param
     * @return
     * @return com.example.demo.utils.RestResponse
     **/
    @RequestMapping("/selectOrder")
    public RestResponse selectOrder(HttpServletRequest request)
    {
String token=request.getHeader("token");
//        使用jwt的工具类，，拿到token里面的用户id
        JwtUtil jwt = new JwtUtil();
        String userId = jwt.getClaim(token).get("userId").toString();

//        自定义的什么状态是历史订单，，加到构造器里面


        try{
            int status = 0;
            QueryWrapper<Order> qw = new QueryWrapper<Order>();
            qw.eq("user_id",userId);
            qw.eq("order_status",status);
            List<Order> list = orderService.selectList(qw);
            return new RestResponse(200,"查询订单成功",list);
        }catch (RuntimeException e){
            e.printStackTrace();
        }

        return new RestResponse(200,"查询订单失败",null);

    };









    @RequestMapping("/publishOrder")
    public RestResponse publishOrder(
                                     String orderType,
                                     String orderDescribe,
                                     String publishTime,
                                     String finishTime,
                                     String orderAddress,
                                     String money,
                                     String myAddress,
                                     HttpServletRequest request)
    {


//        使用jwt的工具类，，拿到token里面的用户id
        String token=request.getHeader("token");
        JwtUtil jwt = new JwtUtil();
        String userId = jwt.getClaim(token).get("userId").toString();

        int orderType2 = Integer.parseInt(orderType);
//        订单已完成状态为2，未完成状态为1，未接收为0

        int orderStatus = 0;

        long time = System.currentTimeMillis();
        Date createTime = new Date(time);

//        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
////        System.out.println(dateFormat.format(date));

        Date startTime = createTime;


        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        sdf.setLenient(false);

        Date fTime;

        try {
            Date endTime = sdf.parse(finishTime);
            fTime = endTime;

        }catch (ParseException e) {
            throw new RuntimeException(e);
        }


        Order entity  = new Order(
                userId,
                orderType2,
                orderStatus,
                createTime,
                startTime,
                fTime,
                myAddress,
                orderAddress,
                orderDescribe
                );

        try{
            orderService.insert(entity);
            return new RestResponse(200,"发布成功",null);
        }catch(RuntimeException e){
            e.printStackTrace();
        }


        return new RestResponse(200,"发布订单失败",null);
    };




    @RequestMapping("/selectOrderStatus")
    public RestResponse selectOrderStatus(HttpServletRequest request)
    {
        String token = request.getHeader("token");
        JwtUtil jwt = new JwtUtil();
        int userId = Integer.parseInt(jwt.getClaim(token).get("userId").toString());

        try{
            int status = orderService.selectOrderStatus(userId);
            return new RestResponse(200,"查询订单状态成功",status);

        }catch (RuntimeException e){
            e.printStackTrace();
        }

        return new RestResponse(202,"查询订单状态失败",null);
    };



    @RequestMapping("/commentOrder")
    public RestResponse commentOrder(HttpServletRequest request,String orderNumber,String comment,int grade)
    {

        String token = request.getHeader("token");
        JwtUtil jwt = new JwtUtil();
        int userId = Integer.parseInt(jwt.getClaim(token).get("userId").toString());
        int orderId = Integer.parseInt(orderNumber);

        try{
            orderService.appraise(orderId,comment,userId,grade);
            return new RestResponse(200,"评论成功",null);

      }catch (RuntimeException e){
            e.printStackTrace();
        }

        return new RestResponse(201,"评论失败",null);
    };








}
