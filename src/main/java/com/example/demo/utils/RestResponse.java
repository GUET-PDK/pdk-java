package com.example.demo.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName RestResponse
 * @Description TODO
 * @Author ctfliar
 * @Date 2023/4/12 15:06
 * @Version 1.0
 **/


@Data
@NoArgsConstructor
public class RestResponse<T>{
    private Integer code;
    private String msg;
    private T data;


    public RestResponse(Integer code, String msg, T data)
    {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    };

//    多态 成功返回的结果
    public static <T> RestResponse success(T data)
    {
        return new RestResponse(200,"success",data);

    };

    public static <T> RestResponse success(String msg,T data)
    {
        return new RestResponse(200,msg,data);
    };



//    多态 失返回的结果
    public static <T> RestResponse error(Integer code)
    {
        return new RestResponse(code,"error",null);
    };

    public static <T> RestResponse error(Integer code, String msg)
    {
        return new RestResponse(code,msg,null);
    };




}
