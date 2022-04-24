package com.zyz.invoke.cglib_proxy;

public class AliSmsService {

    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
