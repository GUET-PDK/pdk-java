package com.example.demo.controller;

import com.example.paodekuai.common.Response.RestResponse;
import com.example.paodekuai.entity.User;
import com.example.paodekuai.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/4/14 14:27
 * @Version 1.0
 **/
@CrossOrigin(origins = "*")
@RestController
@Api("后台接口")
@Slf4j
@RequestMapping(value="/user")
public class UserController extends BaseController{

//    @Autowired
//    private UserMapper userMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    private UserServiceImpl userService;


    @ApiOperation("测试数据库接口")
    @RequestMapping(value = "/testDatabase",method = {RequestMethod.GET,RequestMethod.POST})
    public RestResponse testDatabase(){
        

        DataSource data = jdbcTemplate.getDataSource();
        log.debug("数据测试："+data);
        return new RestResponse(ok ,"数据库连接测试",data);
    };
    
    
    
    

    /**
     * @Author ctfliar
     * @Description //TODO 
     * @Date 10:54 2023/4/21
     * @Param 
     * @param user
     * @return 
     * @return com.example.paodekuai.common.Response.RestResponse
     **/
    @ApiOperation("用户注册")
    public RestResponse register(User user){



        return new RestResponse(ok,"注册成功",null);

    };
    

    
    
    
    /**
     * @Author ctfliar
     * @Description //TODO 
     * @Date 10:56 2023/4/21
     * @Param 
     * @return 
 * @return com.example.paodekuai.common.Response.RestResponse
     **/

    @ApiOperation("用户登录")
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public RestResponse login()
    {

//        查询数据库
        User user = new User();
        user.setUser_name("ctfliar");
        user.setUser_id(1);
        user.setUser_phone("123456");

        userService.save(user);

        return new RestResponse(ok,"返回对象成功",user);

    }




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
    public RestResponse updateName(String name,Integer userId){


    };


    @RequestMapping("/updateAddress")
    public RestResponse updateAddress(@RequestParam("address") String address,Integer userId){


    };


    @RequestMapping("/beRunner")
    public RestResponse beRunner(Integer userId, String idNumber, String cardNumber, MultipartFile idImage,MultipartFile cardImage){

    };



    @RequestMapping("/exit")
    public RestResponse exit(String userId){

    };



}
