package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Apply;
import com.example.demo.mapper.cApplyMapper;
import com.example.demo.service.cApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName cApplyServiceImpl
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/4/25 19:54
 * @Version 1.0
 **/

@Service
public class cApplyServiceImpl extends ServiceImpl<cApplyMapper,Apply> implements cApplyService {


    @Autowired
    cApplyMapper ApplyMapper;


    @Override
    public int insert(Apply entity) {
        return ApplyMapper.insert(entity);
    }
}
