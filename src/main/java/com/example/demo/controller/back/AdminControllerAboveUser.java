package com.example.demo.controller.back;

import com.example.demo.entity.User;
import com.example.demo.service.jyc.inters.AdminOrder;
import com.example.demo.service.jyc.inters.AdminRunner;
import com.example.demo.service.jyc.inters.AdminUser;
import com.example.demo.utils.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AdminControllerAboveUser
 * @Description 管理员对于用户端的操作控制器
 * @Author chao
 * @Date 2023/5/3
 * @Version 1.0
 **/

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class AdminControllerAboveUser {

    @Resource(name = "adminService")
    private AdminUser adminUser;

    @Resource(name = "adminRunner")
    private AdminRunner adminRunner;

    /**
     * 统计用户数量和已注册骑手的数量
     * @return RestResponse<Map<String,Integer>>
     */
    @GetMapping("/countUser")
    public RestResponse<Map<String,Integer>> countUser(){
        HashMap<String, Integer> map = new HashMap<>();

        Integer countUser = adminUser.countUser();
        Integer countRunner = adminRunner.countRunner();
        map.put("count",countUser);
        map.put("runnerCount",countRunner);

        RestResponse success = RestResponse.success(map);
        System.out.println(success);
        return success;
    }

    @GetMapping("getActiveCount")
    public RestResponse<List<Map<String,Integer>>> getActiveCount(){

        List<Map<String,Integer>> data = new ArrayList<>();
        ArrayList<Integer> activeUserNum = adminUser.getActiveUserNum();
        ArrayList<Integer> activeRunnerNum = adminRunner.getActiveRunnerNum();

        for (int i = 0;
             i < (Math.min(activeRunnerNum.size(), activeUserNum.size()));
             i++) {
            Map<String,Integer> map = new HashMap<>();
            map.put("userCount",activeUserNum.get(i));
            map.put("runnerCount",activeRunnerNum.get(i));
            data.add(map);
        }

        RestResponse success = RestResponse.success(data);

        return success;
    }










    /**
     * 获取所有用户信息
     */
    @RequestMapping("/getUserMessage")
    public void getAllUsers(){

    }

    /**
     * 管理员封禁用户账号
     * @param username 用户名
     */
    @RequestMapping("/banUser")
    public void banUser(String username){

    }

    /**
     * 管理员解除用户封禁
     * @param username 用户名
     */
    @RequestMapping("/pinUser")
    public void pinUser(String username){

    }
}
