package com.example.demo.controller.user;

import com.example.demo.entity.Address;
import com.example.demo.entity.User;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.service.impl.cUserServiceImpl;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.RestResponse;
import com.example.demo.utils.upLoads;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/4/14 14:27
 * @Version 1.0
 **/
@CrossOrigin(origins = "*")
@RestController
@Slf4j
@RequestMapping(value="/user")
public class UserController extends BaseController{

//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${files.upload.path}")
    private String upImagePath;

    //服务器返回图片地址
    @Value("${files.get.path}")
    private String getImagePath;



    @Autowired
    private cUserServiceImpl userService;


    /**
     * @Author ctfliar
     * @Description //用户更新自己的昵称
     * @Date 21:08 2023/4/23
     * @Param
     * @param
     * @return
     * @return null
     **/
    @RequestMapping("/updateName")
    public RestResponse updateName(String name){



//        使用jwt的工具类，，拿到token里面的用户id
        JwtUtil jwt = new JwtUtil();
        String userId = jwt.getClaim(token).get("userId");;


        User user = new User();
        user.setUserId(userId);
        user.setUserName(name);
        Integer flag = userService.update(user,null);
        if(flag.equals(1)){

            return new RestResponse(200,"更新用户成功",null);
        }


        return new RestResponse(500,"更新用户名失败",null);
    };


    /**
     * @Author ctfliar
     * @Description //用户更改地址
     * @Date 16:36 2023/4/25
     * @Param
     * @param address
     * @return
     * @return com.example.demo.utils.RestResponse
     **/
    @RequestMapping("/updateAddress")
    public RestResponse updateAddress(@RequestParam("address") String address){


        JwtUtil jwt = new JwtUtil();
        String userId = jwt.getClaim(token).get("userId");;

        try{
            Address data= userService.updateAddress(userId,address);
            return new RestResponse(200,"更新地址成功",data);
        }catch (RuntimeException e){
            e.printStackTrace();
        }

        return new RestResponse(200,"更新地址失败",null);

    };


    @RequestMapping("/beRunner")
    public RestResponse beRunner(String idNumber, String cardNumber, MultipartFile idImage,MultipartFile cardImage){

        String idImagePath = new upLoads().upLoad(idImage,upImagePath,getImagePath);
        String cardImagePath = new upLoads().upLoad(cardImage,upImagePath,getImagePath);




        return new RestResponse(200,"ok",null);
    };



    @RequestMapping("/exit")
    public RestResponse exit(){


//        从token获取用户id，，，，，从token工具类中删除tokon 退出


        return new RestResponse(200,"ok",null);

    };



}
