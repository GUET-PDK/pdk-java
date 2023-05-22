package com.example.demo.controller.user;

import com.example.demo.entity.Address;
import com.example.demo.entity.Order;
import com.example.demo.service.lsx.impl.cOrderServiceImpl;
import com.example.demo.service.lsx.impl.cUserServiceImpl;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName wechatController
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/5/11 17:02
 * @Version 1.0
 **/


@RestController
@CrossOrigin(origins = "*")
public class WechatController extends BaseController{


    @Autowired
    public cUserServiceImpl userService;

    @Autowired
    public cOrderServiceImpl orderService;

//    /**
//     * @Author ctfliar
//     * @Description //TODO
//     * @Date 17:17 2023/5/11
//     * @Param
//     * @param code
//     * @return
//     * @return com.example.demo.utils.RestResponse
//     **/
//    @RequestMapping("/wechat/login")
//    public RestResponse wechatLogin(String code,HttpServletRequest request){
//
//        String token= request.getHeader("token");
//        JwtUtil jwt = new JwtUtil();
//        String userId = jwt.getClaim(token).get("userId").toString();
//
//
//        String openId =  userService.selecetOpenId(userId);
//        if(code.equals(openId)){
//
//            return new RestResponse(200,"ok",null);
//        }
//        else {
//
//            return new RestResponse(500,"error",null);
//        }
//    };
//


    /**
     * @Author ctfliar
     * @Description //用户获取自己发布的订单数量
     * @Date 17:18 2023/5/11
     * @Param
     * @param request
     * @return
     * @return com.example.demo.utils.RestResponse
     **/
    @RequestMapping("/user/getPublishCount")
    @PreAuthorize("hasAuthority('下订单')")
    public RestResponse getPublishCount(HttpServletRequest request){

        String token= request.getHeader("token");
        JwtUtil jwt = new JwtUtil();
        int userId = Integer.parseInt(jwt.getClaim(token).get("userId").toString());;


        List<Order> orderList = orderService.selectOrderListForCount(userId);
        int number=orderList.size();
        Map<String,Integer> data = new HashMap<>();
        data.put("count",number);
        return new RestResponse(200,"ok",data);




    };


//    @RequestMapping("/user/getAccessCount")
//    public RestResponse getAccessCount(HttpServletRequest request){
//
//
//        return new RestResponse(200,"ok",null);
//
//
//    };

    /**
     * @Author ctfliar
     * @Description /获取自己的所有地址
     * @Date 12:29 2023/5/18
     * @Param
     * @param request
     * @return
     * @return com.example.demo.utils.RestResponse
     **/
    @RequestMapping("/user/getAllAddress")
    @PreAuthorize("hasAuthority('下订单')")
    public RestResponse getAllAddress(HttpServletRequest request){


        String token= request.getHeader("token");
        JwtUtil jwt = new JwtUtil();
        int userId = Integer.parseInt(jwt.getClaim(token).get("userId").toString());;


        List<Address> addressList = userService.selectAddressListByUserId(userId);


        return new RestResponse(200,"ok",addressList);


    };




}
