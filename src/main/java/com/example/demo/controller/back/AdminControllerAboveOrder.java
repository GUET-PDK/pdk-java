package com.example.demo.controller.back;

import com.example.demo.dto.OrderMessage;
import com.example.demo.service.jyc.inters.AdminOrder;
import com.example.demo.utils.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AdminControllerAboveOrder
 * @Description 管理员对于订单操作的控制器对象
 * @Author chao
 * @Date 2023/5/3
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminControllerAboveOrder {
    @Resource(name="adminOrder")
    private AdminOrder adminOrder;

    @GetMapping("/gerAllOrders")
    @PreAuthorize("hasAuthority('管理订单')")
    public RestResponse getAllOrders(){
        try {
            List<OrderMessage> allOrders = adminOrder.getAllOrders();
            return RestResponse.success(allOrders);
        } catch (Exception e){
            return RestResponse.error(666, e.getMessage());
        }
    }

    @PostMapping("/deleteOrder")
    @PreAuthorize("hasAuthority('管理订单')")
    public RestResponse deleteOrder(Integer orderId){
        try {
            adminOrder.deleteOrder(orderId);
            return RestResponse.success(null);
        } catch (Exception e) {
            return RestResponse.error(666, e.getMessage());
        }
    }

    @GetMapping("/allOrder")
    @PreAuthorize("hasAuthority('管理订单')")
    public RestResponse getAllOrderNums(){
        Map<String, Integer> map = adminOrder.countOrders();
        return RestResponse.success(map);
    }

}
