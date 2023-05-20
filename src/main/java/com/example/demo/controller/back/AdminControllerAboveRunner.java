package com.example.demo.controller.back;

import com.example.demo.service.jyc.inters.AdminUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName AdminControllerAboveRunner
 * @Description 管理员对于骑手端的操作控制器
 * @Author chao
 * @Date 2023/5/3
 * @Version 1.0
 **/

@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminControllerAboveRunner {

    @Resource(name = "adminService")
    private AdminUser adminUser;

    @RequestMapping("/allowRunner")
    public void allowRunner(String username){

    }

    @RequestMapping("/manageFree")
    public void withdrawals(String username){

    }

    @RequestMapping("/disAllowRunner")
    public void disAgreeRunner(String username){

    }

}
