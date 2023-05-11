package com.example.demo.controller.runner;

import com.example.demo.controller.user.BaseController;
import com.example.demo.entity.Order;
import com.example.demo.service.cxb.IOrderService;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/runner")
public class RunnerOrderController extends BaseController {

    @Autowired
    IOrderService orderService;

    /**
     * 获取历史完成订单
     * @param request
     * @return
     */
    @GetMapping("/sendingOrder")
    public RestResponse getOrders(HttpServletRequest request){
        String token=request.getHeader("token");

       String userId= JwtUtil.getClaim(token).get("userId").toString();
       List<Order> list=orderService.getMyOrder(userId);
       if(list==null||list.size()==0){
           return new RestResponse(200,"已完成的历史订单是空的",null);
       }else {
           return new RestResponse(200,"查询历史订单成功",list);
       }
    }

    /**
     * 获取所有正在发布的订单
     * @return
     */
    @GetMapping("/getOrder")
    public RestResponse getAllOrder(){
       List<Order> list=orderService.getAllOrder();
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
    @GetMapping("confirmOrder")
    public RestResponse confirmOrder(Integer orderId,HttpServletRequest request){
        if(orderId==null){
            //todo 后期可能得要统一异常处理
        }
        String token=request.getHeader("token");
        String userId= JwtUtil.getClaim(token).get("userId").toString();
        orderService.confirmOrder(orderId,userId);
        return new RestResponse(200,"接单成功",null);
    }
}
