package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.controller.vo.UniversalOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName ctfliar
 * @Description TODO
 * @Author zero
 * @Date 2023/5/21 21:43
 * @Version 1.0
 **/
@Mapper
public interface UniversalServiceMapper extends BaseMapper<UniversalOrder> {

    @Override
    int insert(UniversalOrder entity);
}
