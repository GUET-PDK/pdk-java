package com.example.demo.config.securityConfig.exception;


import com.example.demo.utils.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/4/12 16:27
 * @Version 1.0
 **/


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * @Author ctfliar
     * @Description //TODO
     * @Date 16:37 2023/4/12
     * @Param
     * @param e
     * @return 调用Resp.success(" ")可直接返回成功的状态码以及状态信息
     * 使用throw new AppException(AppExceptionCodeMsg.USERNAME_NOT_EXISTS);
     * 可抛出枚举类中定义的异常信息
     * @return com.example.paodekuai.common.Response.RestResponse<T>
     **/
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public <T> RestResponse<T> exceptionHandler(Exception e)
    {
        if(e instanceof AppException){
            AppException appException = (AppException)e;
        log.error("全局异常",e);
            return RestResponse.error(appException.getCode(),appException.getMsg());
        }

        //如果拦截的异常不是我们自定义的异常(例如：数据库主键冲突)
        return RestResponse.error(500,"服务器端异常");
    }

 }


