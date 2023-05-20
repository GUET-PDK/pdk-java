package com.example.demo.controller.user;

import com.example.demo.entity.Address;
import com.example.demo.entity.Apply;
import com.example.demo.entity.User;
import com.example.demo.service.lsx.impl.cApplyServiceImpl;
import com.example.demo.service.lsx.impl.cUserServiceImpl;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.RestResponse;
import com.example.demo.utils.upLoads;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

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


    @Value("${files.upload.path}")
    private String upImagePath;

    //服务器返回图片地址
    @Value("${files.get.path}")
    private String getImagePath;



    @Autowired
    private cUserServiceImpl userService;

    @Autowired
    private cApplyServiceImpl applyService;

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
    public RestResponse updateName(String name, HttpServletRequest request){
       String token= request.getHeader("token");


//        使用jwt的工具类，，拿到token里面的用户id
//        JwtUtil jwt = new JwtUtil();
        String userId = JwtUtil.getClaim(token).get("userId").toString();;


        User user = new User();
        user.setUserId(userId);
        user.setUserName(name);
        Boolean flag = userService.updateById(user);
        if(flag){

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
    public RestResponse updateAddress(@RequestParam("address") String address,HttpServletRequest request){

        String token= request.getHeader("token");
        JwtUtil jwt = new JwtUtil();
        String userId = jwt.getClaim(token).get("userId").toString();;

        try{
            Address data= userService.updateAddress(userId,address);
            return new RestResponse(200,"更新地址成功",data);
        }catch (RuntimeException e){
            e.printStackTrace();
        }

        return new RestResponse(200,"更新地址失败",null);

    };


    @RequestMapping("/beRunner")
    public RestResponse beRunner(String idNumber, String cardNumber, MultipartFile idImage,MultipartFile cardImage,HttpServletRequest request){

        String idImagePath = new upLoads().upLoad(idImage,upImagePath,getImagePath);
        String cardImagePath = new upLoads().upLoad(cardImage,upImagePath,getImagePath);

        String token= request.getHeader("token");
        JwtUtil jwt = new JwtUtil();
        int userId = Integer.parseInt(jwt.getClaim(token).get("userId").toString());;

        Apply apply = new Apply(userId,Integer.parseInt(idNumber),Integer.parseInt(cardNumber),idImagePath,cardImagePath);

        try{
            applyService.insert(apply);
            return new RestResponse(200,"申请成功",null);
        }catch (RuntimeException e)
        {
            //后面改成自己的同意异常处理
            e.printStackTrace();
        }


        return new RestResponse(200,"申请失败",null);
    };



    @RequestMapping("/exit")
    public RestResponse exit(HttpServletRequest request){


//        从token获取用户id，，，，，从token工具类中删除tokon 退出
        String token = request.getHeader("token");

        return new RestResponse(200,"ok",null);

    };



}