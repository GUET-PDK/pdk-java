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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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


    @Value("${uploads.path}")
    private String upImagePath;

    //服务器返回图片地址
    @Value("${get.path}")
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
    @PostMapping("/updateName")
    @PreAuthorize("hasAuthority('下订单')")
    public RestResponse updateName(String userName,String userPhone,MultipartFile userAvator, HttpServletRequest request){
       String token= request.getHeader("token");


//        使用jwt的工具类，，拿到token里面的用户id
//        JwtUtil jwt = new JwtUtil();
        String userId = JwtUtil.getClaim(token).get("userId").toString();;

        String imagePath = new upLoads().upLoad(userAvator,upImagePath,getImagePath);

        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserAvatar(imagePath); //头像
        user.setUserPhone(userPhone);

        int flag = userService.MyUpdateById(user);
        log.debug("flag=",flag);
        if(flag>0){

            return new RestResponse(200,"更新用户成功",null);
        }

        else {


            return new RestResponse(500, "更新用户名失败", null);
        }
        };






    /**
     * @Author ctfliar
     * @Description //用户更改地址
     * @Date 16:36 2023/4/25
     * @Param
     * @param
     * @return
     * @return com.example.demo.utils.RestResponse
     **/
    @PostMapping("/addAddress")
    @PreAuthorize("hasAuthority('下订单')")
    public RestResponse updateAddress(String address_description,String address_phone,String address_name,HttpServletRequest request){

        String token= request.getHeader("token");
        JwtUtil jwt = new JwtUtil();
        String userId = jwt.getClaim(token).get("userId").toString();;

        try{
            userService.updateAddress(userId,address_description,address_phone,address_name);
            return new RestResponse(200,"更新地址成功",null);
        }catch (RuntimeException e){
            e.printStackTrace();
        }

        return new RestResponse(200,"更新地址失败",null);

    };






    @PostMapping(value = "/beRunner")
    @PreAuthorize("hasAuthority('下订单')")
    public RestResponse beRunner(String idNumber, String cardNumber, MultipartFile idImage,MultipartFile cardImage,HttpServletRequest request){

        String idImagePath = new upLoads().upLoad(idImage,upImagePath,getImagePath);
        String cardImagePath = new upLoads().upLoad(cardImage,upImagePath,getImagePath);


        log.debug("图片路径",idImage);

        String token= request.getHeader("token");
        JwtUtil jwt = new JwtUtil();
        String userId = jwt.getClaim(token).get("userId").toString();;

        Apply apply = new Apply();
        apply.setUserId(userId);
        apply.setIdNumber(idNumber);
        apply.setCardNumber(cardNumber);
        apply.setCardImage(cardImagePath);
        apply.setIdImage(idImagePath);


        try{
            int t =applyService.insert(apply);
            return new RestResponse(200,"申请已提交，待审核",null);
        }catch (RuntimeException e)
        {
            //后面改成自己的同意异常处理
            e.printStackTrace();
        }


        return new RestResponse(200,"申请失败",null);
    };



    @PostMapping("/deleteAddress")
    @PreAuthorize("hasAuthority('下订单')")
    public RestResponse deleteAddress(HttpServletRequest request,String addressId ){


        String token= request.getHeader("token");
        JwtUtil jwt = new JwtUtil();
        String userId = jwt.getClaim(token).get("userId").toString();


        try {
            userService.deleteAddress(addressId,userId);
            return new RestResponse(200,"ok",null);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }


    };



    @PostMapping("/uploadImage")
    @PreAuthorize("hasAuthority('下订单')")
    public RestResponse uploadImage(String title,MultipartFile image,HttpServletRequest request){



        String token=request.getHeader("token");
        JwtUtil jwt = new JwtUtil();
        String userId = jwt.getClaim(token).get("userId").toString();


        String imagePath = new upLoads().upLoad(image,upImagePath,getImagePath);

        try {
            userService.upImage(userId,imagePath);
            Map<String,Object> result = new HashMap<>();
            result.put("url",imagePath);
            return new RestResponse(200,"ok",result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }



    @RequestMapping("/getMessage")
    @PreAuthorize("hasAuthority('下订单')")
    public RestResponse getMessage(HttpServletRequest request){

        String token=request.getHeader("token");
        JwtUtil jwt = new JwtUtil();
        String userId = jwt.getClaim(token).get("userId").toString();

        User user = new User();
        user = userService.selectMessageById(userId);

        Map<String,String> result = new HashMap<>();
        result.put("userName",user.getUserName());
        result.put("userPhone",user.getUserPhone());
        result.put("userAvatar",user.getUserAvatar());


        return new RestResponse(200,"查询成功",result);



    }






}
