package com.example.demo.service.jyc.inters;

import java.util.ArrayList;

public interface AdminUser {

    Integer countUser();
    Integer countRunner();

    ArrayList<Integer> getActiveUserNum();

}
