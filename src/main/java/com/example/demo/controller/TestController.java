package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    @PreAuthorize("hasAuthority('下订单')")
    public String test(String msg){
        System.out.println("这是吉安市打开贺卡收到客户卡升级很快的");
        System.out.println(msg);
        return msg;
    }
    @GetMapping("/test2")
    @ResponseBody
    @PreAuthorize("hasAuthority('下订单2')")
    public String test2(String msg){
        System.out.println("这是吉安市打开贺卡收到客户sdassad卡升级很快的");
        System.out.println(msg);
        return msg;
    }

    @GetMapping("/test3")
    @ResponseBody

    public String test3(String msg){
        System.out.println("这是吉安市打开贺卡收到客户sdassad卡升级很fdsf快的");
        System.out.println(msg);
        return msg;
    }
}
