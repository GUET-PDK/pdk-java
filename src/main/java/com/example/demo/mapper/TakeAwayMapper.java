package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.controller.vo.TakeAwayOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName ctfliar
 * @Description TODO
 * @Author zero
 * @Date 2023/5/21 21:33
 * @Version 1.0
 **/
@Mapper
public interface TakeAwayMapper extends BaseMapper<TakeAwayOrder> {

    @Override
    int insert(TakeAwayOrder entity);
}
