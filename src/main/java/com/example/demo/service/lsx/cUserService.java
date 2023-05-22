package com.example.demo.service.lsx;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Address;
import com.example.demo.entity.Apply;
import com.example.demo.entity.User;
import com.example.demo.mapper.cUserMapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @ClassName ctfliar
 * @Description TODO
 * @Author zero
 * @Date 2023/4/25 15:02
 * @Version 1.0
 **/
public interface cUserService extends IService<User>{


    Address updateAddress(String userId, String address,String addressPhone, String addressName);

    public int MyUpdateById(User entity);


    void deleteAddress(String addressId,String userId);


    String selecetOpenId(String userId);

    List<Address> selectAddressListByUserId(int userId);


}
