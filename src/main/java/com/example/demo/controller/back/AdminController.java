package com.example.demo.controller.back;


import com.example.demo.config.exception.AppException;
import com.example.demo.config.exception.AppExceptionCodeMsg;
import com.example.demo.service.cxb.IUserService;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.RedisCache;
import com.example.demo.utils.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

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
    @Autowired
    private IUserService userService;

    @Autowired
    RedisCache redisCache;
    /**
     * 登录获取验证码
     */
    @RequestMapping("/getCode")
    public RestResponse getCode(String phone) throws Exception {

        if ((phone != null) && (!phone.isEmpty())) {
            if(!Pattern.matches("^1[3-9]\\d{9}$", phone)){

                throw new AppException(AppExceptionCodeMsg.PARAMS_ERROR);
            }
            System.out.println("进入到这里了");
        }
        boolean b = userService.sentCode(phone);
        if(b){
            return new RestResponse(200,"验证码发送成功",null);
        }else {
            return new RestResponse(408,"该手机号没有绑定用户",null);
        }
    }


    /**
     * 管理员退出
     */
    @RequestMapping("/exit")
    public RestResponse exit(HttpServletRequest request){
        String token = request.getHeader("token");
        redisCache.deleteObject("login_"+token);
        return new RestResponse(200,"退出成功",null);
    }


}
