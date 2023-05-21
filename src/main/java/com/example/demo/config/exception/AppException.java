package com.example.demo.config.exception;

import lombok.Data;

/**
 * @ClassName AppException
 * @Description 自定义异常类
 * @Author ctfliar
 * @Date 2023/4/12 15:34
 * @Version 1.0
 **/

@Data
public class AppException extends RuntimeException{

   private Integer code;
   private String msg ;




//   多态定义两种  异常处理，，，，，一个是枚举类enmus里面的异常，，，另一个是这里自定义的异常处理


//    enums枚举的异常处理
    public AppException(AppExceptionCodeMsg appExceptionCodeMsg)
    {
        super();
        this.code = appExceptionCodeMsg.getCode();
        this.msg = appExceptionCodeMsg.getMsg();
    }

//  不在自定义列举的异常处理之中，，，，归为服务器异常
    public AppException(String message, Integer errCode) {
        super();
        this.code = errCode;
        this.msg = message;
    }


    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
