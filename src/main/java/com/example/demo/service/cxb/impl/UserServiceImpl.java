package com.example.demo.service.cxb.impl;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;
import com.aliyun.tea.TeaException;
import com.aliyun.teautil.Common;
import com.aliyun.teautil.models.RuntimeOptions;
import com.example.demo.config.exception.AppException;
import com.example.demo.config.exception.AppExceptionCodeMsg;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.cxb.IUserService;
import com.example.demo.utils.RedisCache;
import com.example.demo.utils.RoleEnum;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisCache redisCache;

    @Override
    public boolean addNewUser(User user) {
        int a = userMapper.insert(user);
        int roleId = userMapper.selectRoleIdByRoleName(RoleEnum.普通用户.name());
        int b = userMapper.insertMiddleUserRole(user.getUserId(), roleId);
        if (a + b == 2)
            return true;
        else return false;
    }

    @Override
    public Set revocation(String userId) {

        Integer id = userMapper.selectMiddleIdByUserId(userId);
        if (id == null) {

            throw new AppException(AppExceptionCodeMsg.DATA_ERROR);
        }
        int i = userMapper.deleteMiddleRoleById(id);
        if (i == 0) {
            throw new AppException(AppExceptionCodeMsg.DATA_ERROR);
        }
       Set<String> set=userMapper.selectPermissionByUserId(userId);
        return set;
    }

    @Override
    public boolean sentCode(String phone) throws Exception {

        Map map = new HashMap();
        map.put("user_phone", phone);
        List list = userMapper.selectByMap(map);
        if (list == null || list.size() == 0) {
            return false;
        }
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                // 必填，您的 AccessKey ID
                .setAccessKeyId("xxxx")
                // 必填，您的 AccessKey Secret
                .setAccessKeySecret("xxxxx");
        // 访问的域名
        System.out.println("呵呵艰苦环境和");
        config.endpoint = "dysmsapi.aliyuncs.com";
        Client client = new Client(config);
        Random random = new Random();
        int i = random.nextInt(9999);
        String s = String.valueOf(i);
        String code = "{\"code\":\"" + s + "\"}";

        com.aliyun.dysmsapi20170525.models.SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers(phone)
                .setTemplateParam(code)
                .setSignName("xxx")
                .setTemplateCode("xxxx");

//        try {
        // 复制代码运行请自行打印 API 的返回值
        SendSmsResponse sendSmsResponse = client.sendSmsWithOptions(sendSmsRequest, new RuntimeOptions());
        SendSmsResponseBody body = sendSmsResponse.body;
        System.out.println(body.toString());
        Map<String, Object> map1 = body.toMap();
        System.out.println(map1.get("Message"));

        System.out.println(map1.get("Message")+"            hhhhhhh");
        if (!map1.get("Message").equals("OK")) {

            throw new AppException(AppExceptionCodeMsg.PHONE_ERROR);

        } else {

            redisCache.setCacheObject("Phone_" + phone, s, 5, TimeUnit.MINUTES);
            return true;

//            System.out.println(new Gson().toJson(sendSmsResponse.body));
//            System.out.println("hhhhhh");
//        } catch (TeaException error) {
//            // 如有需要，请打印 error
//            System.out.println("jshdfjksajkgd");
//            System.out.println(error);
//            System.out.println(Common.assertAsString(error.message));
//        } catch (Exception _error) {
//            System.out.println("sajghfsagfjhdbsafs");
//            System.out.println(_error);
//            TeaException error = new TeaException(_error.getMessage(), _error);
//            // 如有需要，请打印 error
//            System.out.println(Common.assertAsString(error.message));
//        }
        }

    }
}
