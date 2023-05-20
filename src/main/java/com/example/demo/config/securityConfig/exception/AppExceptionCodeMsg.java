package com.example.demo.config.securityConfig.exception;

import lombok.AllArgsConstructor;

/**
 * @ClassName AppExceptionCodeMsg
 * @Description 定义枚举类 内可包含业务异常，统一异常处理会进行拦截返回对应的错误码和错误信息
 * @Author ctfliar
 * @Date 2023/4/12 16:08
 * @Version 1.0
 **/



@AllArgsConstructor
public enum AppExceptionCodeMsg {
    INVALID_CODE(403,"验证码无效，请重新登录"),
    USERNAME_NOT_EXISTS(402,"用户名不存在，请重新登录"),
    USER_CREDIT_NOT_ENOUTH(400,"用户积分不足"),

    USER_TOKEN_NOT_EXISTS(401,"无token,请重新登录"),
    USER_TOKEN_ERROR(406,"用户验证失败，请重新登录"),
    USER_TOKEN_PASSWORD_ERROR(407,"token验证密码失败，请重新登录"),


    USER_NOT_EXISTS(405,"用户不存在，请重新登录");


    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
