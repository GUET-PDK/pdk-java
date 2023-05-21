package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.controller.vo.SentPublishOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName ctfliar
 * @Description TODO
 * @Author zero
 * @Date 2023/5/21 21:10
 * @Version 1.0
 **/
@Mapper
public interface SentPublishMapper extends BaseMapper<SentPublishOrder> {

    @Override
    int insert(SentPublishOrder entity);
}
