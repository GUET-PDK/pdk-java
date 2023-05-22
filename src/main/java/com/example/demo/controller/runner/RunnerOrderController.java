package com.example.demo.controller.runner;

import com.alibaba.fastjson2.JSONObject;
import com.example.demo.config.exception.AppException;
import com.example.demo.config.exception.AppExceptionCodeMsg;
import com.example.demo.controller.user.BaseController;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.service.cxb.IOrderService;
import com.example.demo.service.cxb.IUserService;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.RedisCache;
import com.example.demo.utils.RestResponse;
import com.example.demo.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/runner")
public class RunnerOrderController extends BaseController {

    @Autowired
    IOrderService orderService;

    @Autowired
    IUserService userService;

    @Autowired
    RedisCache redisCache;
    /**
     * 获取自己已接取过的订单
     * @param request
     * @return
     */
    @GetMapping("/selectNowOrder")
    @PreAuthorize("hasAuthority('接单')")
    public RestResponse getOrders(Integer orderStatus,HttpServletRequest request){
        if(orderStatus!=null){
            if(orderStatus>2||orderStatus<1){

                throw new AppException(AppExceptionCodeMsg.PARAMS_ERROR);
            }
        }
        String token=request.getHeader("token");

       String userId= JwtUtil.getClaim(token).get("userId").toString();
       List<OrderVo> list=orderService.getMyOrder(orderStatus,userId);
       if(list==null||list.size()==0){
           return new RestResponse(200,"已完成的历史订单是空的",null);
       }else {
           return new RestResponse(200,"查询历史订单成功",list);
       }
    }

    /**
     * 获取正在发布的订单
     * @return
     */
    @GetMapping("/getOrder")
    @PreAuthorize("hasAuthority('接单')")
    public RestResponse getAllOrder(Integer orderType){
        if(orderType!=null){
            if(orderType<0||orderType>3){
                throw new AppException(AppExceptionCodeMsg.PARAMS_ERROR);
            }
        }

       List<OrderVo> list=orderService.getAllOrder(orderType);
        if(list==null||list.size()==0){
            return new RestResponse(200,"当前没有订单",null);
        }else {
            return new RestResponse(200,"查询所有正在发布的订单成功",list);
        }
    }

    /**
     * 骑手接单
     * @param orderId
     * @param request
     * @return
     */
    @PostMapping("confirmOrder")
    @PreAuthorize("hasAuthority('接单')")
    public RestResponse confirmOrder(Integer orderId,HttpServletRequest request){
        if(orderId==null){
            throw new AppException(AppExceptionCodeMsg.PARAMS_ERROR);
        }
        String token=request.getHeader("token");
        String userId= JwtUtil.getClaim(token).get("userId").toString();
        orderService.confirmOrder(orderId,userId);
        return new RestResponse(200,"接单成功",null);
    }


    /**
     * 获取某个订单的详细信息
     * @param orderId
     * @param request
     * @return
     */
    @GetMapping("/orderMessage")
    @PreAuthorize("hasAuthority('接单')")
    public RestResponse orderMessage(Integer orderId,HttpServletRequest request){

        if(orderId==null){
            throw new AppException(AppExceptionCodeMsg.PARAMS_ERROR);
        }
        String token=request.getHeader("token");
        String userId= JwtUtil.getClaim(token).get("userId").toString();
        Object object=orderService.getOrderDetail(orderId,userId);
        return new RestResponse(200,"返回详细信息成功",object);
    }

    /**
     * 骑手申请身份撤销
     * @param request
     * @return
     */
    @PostMapping("revocation")
    @PreAuthorize("hasAuthority('接单')")
    public RestResponse revocation(HttpServletRequest request){


       String token= request.getHeader("token");
       String userId= JwtUtil.getClaim(token).get("userId").toString();
      Set<String> set= userService.revocation(userId);
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Object permissionCode : set) {
            String permission= permissionCode.toString();
            if (permission != null && permission != "") {
                GrantedAuthority grantedAuthority =
                        new SimpleGrantedAuthority(permission);
                authorities.add(grantedAuthority);
            }
        }
       redisCache.setCacheObject("login_"+token,authorities,3000, TimeUnit.MINUTES);
        return new RestResponse(200,"撤销成功",null);

    }

    /**
     * 获取自己接过的订单数量
     * @param request
     * @return
     */
    @GetMapping("/getAccessCount")
    @PreAuthorize("hasAuthority('下订单')")
    public RestResponse getAccessCount(HttpServletRequest request){
        String token= request.getHeader("token");
        String userId= JwtUtil.getClaim(token).get("userId").toString();
       int count= orderService.getOrderCountByUserId(userId);
        Map<String,Integer> map=new HashMap<>();
        map.put("count",count);
        RestResponse response=new RestResponse(200,"返回成功",map);
    return response;
    }

}
