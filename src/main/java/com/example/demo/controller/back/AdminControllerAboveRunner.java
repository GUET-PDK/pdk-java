package com.example.demo.controller.back;

import com.example.demo.dto.ApplyMessage;
import com.example.demo.service.jyc.inters.AdminRunner;
import com.example.demo.service.jyc.inters.AdminUser;
import com.example.demo.utils.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AdminControllerAboveRunner
 * @Description 管理员对于骑手端的操作控制器
 * @Author chao
 * @Date 2023/5/3
 * @Version 1.0
 **/

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class AdminControllerAboveRunner {

    @Resource(name = "adminRunner")
    private AdminRunner adminRunner;

    @GetMapping("/countApplication")
    @PreAuthorize("hasAuthority('管理用户')")
    public RestResponse countApplication(){
        Map<String, Integer> map = adminRunner.countApplication();
        RestResponse success = RestResponse.success(map);
        return success;
    }

    @GetMapping("/getRunnerApplyMessage")
    @PreAuthorize("hasAuthority('管理用户')")
    public RestResponse getRunnerApplyMessage(String id){
        ApplyMessage runnerApplyMessage = adminRunner.getRunnerApplyMessage(id);
        return RestResponse.success(runnerApplyMessage);
    }


    @PostMapping("/allowRunner")
    @PreAuthorize("hasAuthority('管理用户')")
    public RestResponse allowRunner(Integer id){
        int nums = adminRunner.allowRunner(id);
        if (nums==2) {
            return RestResponse.success(null);
        } else {
            return RestResponse.error(666,"更新出错辣");
        }
    }

    @PostMapping("/disAllowRunner")
    @PreAuthorize("hasAuthority('管理用户')")
    public RestResponse disAgreeRunner(Integer id){
        int i = adminRunner.disAgreeRunner(id);
        if (i==1) {
            return RestResponse.success(null);
        } else {
            return RestResponse.error(666,"后端又错了");
        }
    }

}
