package com.example.demo;

import com.example.demo.mapper.AdminOrderMapper;
import com.example.demo.service.jyc.inters.AdminOrder;
import com.example.demo.service.jyc.inters.AdminRunner;
import com.example.demo.service.jyc.inters.AdminUser;
import com.example.demo.utils.RoleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;

@SpringBootTest
class DemoApplicationTests {
    @Resource(name="adminUser")
    AdminUser adminUser;

    @Resource
    AdminOrder adminOrder;
    @Resource
    AdminOrderMapper adminOrderMapper;

    @Test
    void contextLoads() {

        int a=0;
        Integer b = 1;
        a = b;
        System.out.println(a);

    }

    @Test
    void testAdmin(){
        System.out.println(adminUser.countUser());
    }

    @Test
    void testSelectAll(){
        System.out.println(adminUser.getAllUsers());
    }

//    @Test
//    void testUpdate(){
//        System.out.println(adminUser.banUser("c2348078-398b-4978-af65-8bb6579993e7",0));
//    }

    @Test
    void testAdminOrder(){
        System.out.println(adminOrder.getAllOrders());
    }

    @Resource(name = "adminRunner")
    private AdminRunner adminRunner;
    @Test
    void testAllow(){
        adminRunner.allowRunner(15);
    }

}
