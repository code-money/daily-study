package cn.zyz.juc.interrupt;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-08-30 09:52
 **/

public class InterruptDemo4 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"---"+Thread.interrupted());
        System.out.println(Thread.currentThread().getName()+"---"+Thread.interrupted());
        System.out.println("------1");
        Thread.currentThread().interrupt();///----false---> true
        System.out.println("------2");
        System.out.println(Thread.currentThread().getName()+"---"+Thread.interrupted());
        System.out.println(Thread.currentThread().getName()+"---"+Thread.interrupted());
    }
}



