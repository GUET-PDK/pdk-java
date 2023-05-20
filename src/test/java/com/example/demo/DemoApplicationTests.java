package com.example.demo;

import com.example.demo.service.jyc.inters.AdminUser;
import com.example.demo.utils.RoleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {
    @Resource
    AdminUser adminUser;

    @Test
    void contextLoads() {
        System.out.println(RoleEnum.普通用户.name());
    }

    @Test
    void testAdmin(){
        System.out.println(adminUser.countUser());
    }

}
