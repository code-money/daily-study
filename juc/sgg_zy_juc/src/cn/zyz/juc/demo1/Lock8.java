package cn.zyz.juc.demo1;

import java.util.concurrent.TimeUnit;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-07-14 11:21
 *
 *
 * 题目：多线程8锁
 **/
class Phone {
    public static synchronized void sendEmail() throws Exception {
        //暂停4秒钟
        TimeUnit.SECONDS.sleep(4);
        System.out.println("------sendEmail");
    }

    public synchronized void sendSMS() throws Exception {
        System.out.println("------sendSMS");
    }

    public void hello(){
        System.out.println("------hello");
    }
}


public class Lock8 {
    public static void main(String[] args) throws Exception {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "线程1").start();
        Thread.sleep(100);
        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "线程2").start();
//        new Thread(() -> {
//            try {
//                phone.hello();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }, "线程3").start();
    }
}



