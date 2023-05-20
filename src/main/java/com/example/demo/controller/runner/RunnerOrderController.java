package com.example.demo.controller.runner;

import com.alibaba.fastjson2.JSONObject;
import com.example.demo.controller.user.BaseController;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.service.cxb.IOrderService;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.RestResponse;
import com.example.demo.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.java2d.loops.GeneralRenderer;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/runner")
public class RunnerOrderController extends BaseController {

    @Autowired
    IOrderService orderService;

    /**
     * 获取自己已接取过的订单
     * @param request
     * @return
     */
    @GetMapping("/selectNowOrder")
    public RestResponse getOrders(Integer orderStatus,HttpServletRequest request){
        if(orderStatus!=null){
            if(orderStatus>2||orderStatus<1){
                //todo 异常处理
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
    public RestResponse getAllOrder(Integer orderType){
        if(orderType!=null){
            if(orderType<0||orderType>3){
                //todo 这是异常
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
    public RestResponse confirmOrder(Integer orderId,HttpServletRequest request){
        if(orderId==null){
            //todo 后期可能得要统一异常处理
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
    public RestResponse orderMessage(Integer orderId,HttpServletRequest request){

        if(orderId==null){
            //todo 后期可能得要统一异常处理
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
    public RestResponse revocation(HttpServletRequest request){
//todo 这里牵连出一大部分问题，我打算中间表撤销骑手那块直接删了算了，还有关于用户表状态需要更改的问题后面还需要更新sql语句来搞登录的东西
return null;
    }

}
