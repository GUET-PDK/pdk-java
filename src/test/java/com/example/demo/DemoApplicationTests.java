package com.example.demo;

import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.RoleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {

        int a=0;
        Integer b = 1;
        a = b;
        System.out.println(a);

    }

}
