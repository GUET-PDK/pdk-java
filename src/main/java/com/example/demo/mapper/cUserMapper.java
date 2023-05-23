package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Address;
import com.example.demo.entity.Apply;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName ctfliar
 * @Description TODO
 * @Author zero
 * @Date 2023/4/25 14:57
 * @Version 1.0
 **/
@Mapper
public interface cUserMapper extends BaseMapper<User> {



//    userId,address,addressPhone,addressName
    void updateAddress(String userId,String address,String addressPhone,String addressName);

    void deleteAddress(String addressId,String userId);


    @Select("select open_id from sys_user where user_id = #{userId}")
    String selectOpenId(String userId);


    @Select("select address_id," +
            "address_description," +
            "address_name,address_phone,user_id "+
            "from sys_user_address where user_id = #{userId}")
    List<Address> selectAddressListByUserId(String userId);


    @Insert("insert into sys_user_image(user_id,image_url) values(#{userId},#{imageUrl})")
    void upImage(String userId, String imageUrl);
}
