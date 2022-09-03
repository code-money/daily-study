package cn.zyz.juc.aboutLocks;

import java.util.concurrent.TimeUnit;


/**
 *
 * 8锁问题
 */
public class Lock8Demo {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            phone1.sendEmail();
        }, "a").start();

        //暂停一下主线程，让a先启动
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone1.hello();
            //phone1.sendSMS();
            //phone2.sendSMS();

        }, "b").start();
    }
}

class Phone {
    public  synchronized void sendEmail() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-----sendEmail");
    }

    public synchronized void sendSMS() {
        System.out.println("-----sendSMS");
    }

    private static Object object = new Object();

    public void hello() {
        //synchronized (this) {
        synchronized (object) {
            System.out.println("-----Hello");
        }
    }
}



