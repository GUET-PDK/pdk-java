package com.example.demo.controller.user;

import com.example.demo.service.impl.cUserServiceImpl;
import com.example.demo.utils.RestResponse;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName UserOrderController
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/4/21 10:56
 * @Version 1.0
 **/
public class UserOrderController extends BaseController{


    private cUserServiceImpl UserService;


    @RequestMapping("/selectOrder")
    public RestResponse selectOrder()
    {


        return new RestResponse(200,"ok",null);
    };


    @RequestMapping("/publishOrder")
    public RestResponse publishOrder(Integer userId,
                                     String orderType,
                                     String orderDescribe,
                                     String publishTime,
                                     String finishTime,
                                     String orderAddress,
                                     String money)
    {



        return new RestResponse(200,"ok",null);
    };




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
