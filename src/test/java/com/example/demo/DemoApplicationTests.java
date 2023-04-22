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
        System.out.println(RoleEnum.普通用户.name());
    }

}
