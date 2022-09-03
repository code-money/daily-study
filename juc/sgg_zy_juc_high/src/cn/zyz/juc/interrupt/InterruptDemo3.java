package cn.zyz.juc.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-08-30 09:34
 **/

public class InterruptDemo3 {
    public static void main(String[] args) {
        Thread t1 =new Thread(()->{
            while (true){
                if (Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread().getName()+"\t"+"中断标志位："+Thread.currentThread().isInterrupted()+" 程序停止");
                    break;
                }

                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                }catch (Exception e){
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }

                System.out.println("hello------interruptDemo03");
            }
        },"t1");

        t1.start();
        //暂停几秒钟线程
        try { TimeUnit.MILLISECONDS.sleep(1000);}catch (Exception e){e.printStackTrace();}

        new Thread(()->{
            t1.interrupt();
        },"t2").start();
    }
}



