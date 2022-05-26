package com.zyz.utils;

/**
 * @program: day01_eesy_03spring
 * @author: zyz
 * @create: 2022-05-23 18:03
 **/

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类
 */

@Component("logger")
@Aspect
public class Logger {


    //配置切入点
    @Pointcut("execution(* com.zyz.service.impl.*.*(..))")
    public void pt1(){};

    /**
     * 前置通知
     */
    @Before("pt1()")
    public void beforePrintLog(){
        System.out.println("前置通知logger类中的pringlog方法开始记录日志");
    }

    /**
     * 后置通知
     */
    @AfterReturning("pt1()")
    public void afterReturnPrintLog(){
        System.out.println("后置通知logger类中的pringlog方法开始记录日志");
    }

    /**
     * 异常通知
     */
    @AfterThrowing("pt1()")
    public void afterThrowingPrintLog(){
        System.out.println("异常通知logger类中的pringlog方法开始记录日志");
    }

    /**
     * 最终通知
     */
    @After("pt1()")
    public void afterPrintLog(){
        System.out.println("最终通知logger类中的pringlog方法开始记录日志");
    }

    /**
     * 环绕通知
     */
//    @Around("pt1()")
//    public Object aroundPrintLog(ProceedingJoinPoint pjp){
//        Object rtValue=null;
//        try{
//            Object[] args = pjp.getArgs();//得到方法执行所需的参数
//            System.out.println("前置通知logger类中的pringlog方法开始记录日志");
//            rtValue = pjp.proceed(args);
//            System.out.println("后置通知logger类中的pringlog方法开始记录日志");
//            return rtValue;
//        }catch (Throwable throwable){
//            System.out.println("异常通知logger类中的pringlog方法开始记录日志");
//            throw new RuntimeException(throwable);
//        }finally {
//            System.out.println("最终通知logger类中的pringlog方法开始记录日志");
//        }
//    }

}



