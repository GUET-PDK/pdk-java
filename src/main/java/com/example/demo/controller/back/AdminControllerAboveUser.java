package com.example.demo.controller.back;

import com.example.demo.entity.User;
import com.example.demo.service.jyc.inters.AdminRunner;
import com.example.demo.service.jyc.inters.AdminUser;
import com.example.demo.utils.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

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
        //System.out.println(success);
        return (RestResponse<Map<String,Integer>>) RestResponse.success(map);
    }

    /**
     * 统计上一周用户和骑手的活跃度
     *
     * @return RestResponse<List < Map < String, Integer>>>
     */
    @GetMapping("getActiveCount")
    public RestResponse getActiveCount(){

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
        return (RestResponse<List<Map<String,Integer>>>) RestResponse.success(data);
    }

    /**
     * 获取所有用户信息
     */
    @GetMapping("/getUserMessage")
    public RestResponse getAllUsers(){
        List<User> allUsers = adminUser.getAllUsers();
        RestResponse success = RestResponse.success(allUsers);
        return success;
    }

    /**
     * 管理员封禁用户账号
     * @param userId 用户Id
     */
    @PostMapping("/banUser")
    public RestResponse banUser(String userId){
        RestResponse response = RestResponse.success(null);
        try {
            adminUser.banUser(userId,1);
        } catch (Exception e) {
            response.setCode(666);
            response.setMsg(e.getMessage());
        }
        return response;
    }

    /**
     * 管理员解除用户封禁
     * @param userId 用户名
     */
    @PostMapping("/pinUser")
    public RestResponse pinUser(String userId){
        RestResponse response = RestResponse.success(null);
        try {
            adminUser.pinUser(userId,0);
        } catch (Exception e) {
            response.setCode(666);
            response.setMsg(e.getMessage());
        }
        return response;
    }
}
