package com.example.demo.controller;

import com.example.paodekuai.common.Response.RestResponse;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName UserOrderController
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/4/21 10:56
 * @Version 1.0
 **/
public class UserOrderController extends BaseController{


    @RequestMapping("/selectOrder")
    public RestResponse selectOrder(Integer userId)
    {

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

    };




    @RequestMapping("/selectOrderStatus")
    public RestResponse selectOrderStatus(Integer userId)
    {

    };



    @RequestMapping("/commentOrder")
    public RestResponse commentOrder(Integer userId)
    {

    };








}
