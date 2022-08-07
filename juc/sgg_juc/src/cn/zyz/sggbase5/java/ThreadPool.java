package cn.zyz.sggbase5.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 创建线程的方式4，线程池
 * @program: juc
 * @author: zyz
 * @create: 2022-07-12 12:45
 **/

public class ThreadPool {
    public static void main(String[] args) {


        //1.提供指定数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        //设置线程池的属性


        //2.执行指定的线程的操作
        service.execute(()->{  //适用于Runnable
            for (int i = 0; i <=100; i++) {
                if (i%2==0){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }

        });
        service.execute(()->{  //适用于Runnable
            for (int i = 0; i <=100; i++) {
                if (i%2!=0){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        });
//        service.submit();   //适用于Callable
        //关闭连接池
        service.shutdown();
    }
}



