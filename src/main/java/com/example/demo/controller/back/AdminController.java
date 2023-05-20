package com.example.demo.controller.back;

import com.example.demo.service.jyc.inters.AdminService;
import com.example.demo.utils.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName AdminController
 * @Description 关于管理员相关操作的控制器
 * @Author chao
 * @Date 2023/5/3
 * @Version 1.0
 **/

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class AdminController {
    @Resource(name = "adminService")
    private AdminService adminService;

    /**
     * 登录获取验证码
     */

    @RequestMapping("/getCode")
    public RestResponse getCode(String phone){
return null;
    }
    /**
     * 管理员登陆
     * @param name
     * @param password
     */
    @RequestMapping("/login")
    public void adminLogin(String name,String password){

    }

    /**
     * 管理员退出
     */
    @RequestMapping("/exit")
    public void exit(){

    }


}
