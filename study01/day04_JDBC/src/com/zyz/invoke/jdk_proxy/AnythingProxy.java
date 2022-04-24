package com.zyz.invoke.jdk_proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/*
    相比于静态代理来说，动态代理更加灵活。我们不需要针对每个目标类都单独创建一个代理类，并且也不需要我们必须实现接口
 */
public class AnythingProxy implements InvocationHandler {

    //final修饰的变量必须赋初始值否则报错  或者final修饰的变量在构造方法赋值的话不会报错
    final Object target;

    public AnythingProxy(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("日志前");
        Object invoke = method.invoke(target, args);
        System.out.println("日志后");
        return invoke;
    }

    public Object getInstance(){
        Object obj = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return obj;
    }
}
