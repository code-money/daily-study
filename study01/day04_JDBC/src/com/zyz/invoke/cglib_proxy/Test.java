package com.zyz.invoke.cglib_proxy;

public class Test {
    public static void main(String[] args) {
        //方法一不构建代理工厂
//        Enhancer enhancer = new Enhancer();
//        DebugMethodInterceptor interceptor = new DebugMethodInterceptor();
//        enhancer.setSuperclass(AliSmsService.class);
//        enhancer.setCallback(interceptor);
//
//        AliSmsService aliSmsService =(AliSmsService) enhancer.create();
//        aliSmsService.send("你好");

        //方法二根据代理工厂来构建
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java");

        Thread thread = new Thread();


    }
}
