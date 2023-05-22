package com.example.demo.service.jyc.inters;

import com.example.demo.dto.ApplyMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface AdminRunner {
    Integer countRunner();

    ArrayList<Integer> getActiveRunnerNum();

    Map<String,Integer> countApplication();

    ApplyMessage getRunnerApplyMessage(String id);

    int allowRunner(Integer id);

    int disAgreeRunner(Integer id);

    List<ApplyMessage> getApplyList();
}
