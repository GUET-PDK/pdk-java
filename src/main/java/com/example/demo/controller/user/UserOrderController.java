package com.example.demo.controller.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Order;
import com.example.demo.service.lsx.impl.cOrderServiceImpl;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.RestResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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









//    @RequestMapping("/publishOrder")
//    public RestResponse publishOrder(
//                                     String orderType,
//                                     String orderDescribe,
//                                     String publishTime,
//                                     String finishTime,
//                                     String orderAddress,
//                                     String money,
//                                     HttpServletRequest request)
//    {
//
//
////        使用jwt的工具类，，拿到token里面的用户id
//        String token=request.getHeader("token");
//        JwtUtil jwt = new JwtUtil();
//        String userId = jwt.getClaim(token).get("userId").toString();
//
//
//
//
//        Order entity  = new Order(
//                userId,
//                orderType,
//                orderStatus,
//                createTime,
//                startTime,
//                finishTime,
//                myAddress,
//                orderAddress,
//                orderDescribe
//                );
//
//        orderService.insert(entity);
//
//
//        return new RestResponse(200,"ok",null);
//    };
//



    @RequestMapping("/selectOrderStatus")
    public RestResponse selectOrderStatus(Integer userId)
    {
        return new RestResponse(200,"ok",null);
    };



    @RequestMapping("/commentOrder")
    public RestResponse commentOrder(Integer userId)
    {
        return new RestResponse(200,"ok",null);
    };








}
