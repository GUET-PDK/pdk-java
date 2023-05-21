package com.example.demo;

import com.example.demo.service.jyc.inters.AdminUser;
import com.example.demo.utils.RoleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;

@SpringBootTest
class DemoApplicationTests {
    @Resource(name="adminService")
    AdminUser adminUser;

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

    @Test
    void testUpdate(){
        System.out.println(adminUser.banUser("c2348078-398b-4978-af65-8bb6579993e7",1));
    }



}
