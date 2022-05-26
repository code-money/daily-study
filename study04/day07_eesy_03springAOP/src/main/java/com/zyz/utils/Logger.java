package com.zyz.utils;

/**
 * @program: day01_eesy_03spring
 * @author: zyz
 * @create: 2022-05-23 18:03
 **/

/**
 * 用于记录日志的工具类
 */
public class Logger {
    /**
     * 用于打印日志：计划其在切入点方法执行之前执行(切入点方法就是业务层方法)
     */
    public void printLog(){
        System.out.println("logger类中的pringlog方法开始记录日志");
    }
}



