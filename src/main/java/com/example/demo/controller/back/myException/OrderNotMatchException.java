package com.example.demo.controller.back.myException;

/**
 * @ClassName OrderNotMatchException
 * @Description TODO
 * @Author chao
 * @Date 2023/5/22
 * @Version 1.0
 **/
public class OrderNotMatchException extends RuntimeException{
    public OrderNotMatchException(String message) {
        super(message);
    }
}
