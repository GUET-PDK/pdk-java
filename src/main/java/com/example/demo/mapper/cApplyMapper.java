package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Apply;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName ctfliar
 * @Description TODO
 * @Author zero
 * @Date 2023/4/25 19:48
 * @Version 1.0
 **/

@Mapper
public interface cApplyMapper extends BaseMapper<Apply> {

    @Override
    int insert(Apply entity);

}
