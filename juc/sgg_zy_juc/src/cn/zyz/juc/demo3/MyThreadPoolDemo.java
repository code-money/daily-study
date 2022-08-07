package cn.zyz.juc.demo3;

import java.util.concurrent.*;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-07-15 17:28
 **/

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        //自定义线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        try {
            for (int i = 0; i < 20; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                });
//                Thread.sleep(300);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
        System.out.println(threadPool.isTerminated());
    }


    //使用自带API(Executors)生成线程池
    public static void initPool() {
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5个线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池1个线程
        ExecutorService threadPool = Executors.newCachedThreadPool();//一池N个线程
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                });
                //        Thread.sleep(300);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}



