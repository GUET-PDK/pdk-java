package com.example.demo.controller.back;

import com.example.demo.service.jyc.inters.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName AdminControllerForUser
 * @Description 管理员对于用户端的操作控制器
 * @Author chao
 * @Date 2023/5/3
 * @Version 1.0
 **/

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class AdminControllerAboveUser {

    @Resource(name = "adminService")
    private AdminService adminService;
    /**
     * 获取所有用户信息
     */
    @RequestMapping("/getUserMessage")
    public void getAllUsers(){

    }

    /**
     * 管理员封禁用户账号
     * @param username 用户名
     */
    @RequestMapping("/banUser")
    public void banUser(String username){

    }

    /**
     * 管理员解除用户封禁
     * @param username 用户名
     */
    @RequestMapping("/pinUser")
    public void pinUser(String username){

    }
}
