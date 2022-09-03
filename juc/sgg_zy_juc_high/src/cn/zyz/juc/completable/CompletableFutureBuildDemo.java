package cn.zyz.juc.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @program: juc2021
 * @author: zyz
 * @create: 2022-08-27 16:01
 **/

public class CompletableFutureBuildDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*ExecutorService threadPool = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            //暂停几秒钟
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },threadPool);
        System.out.println(completableFuture.get());*/

        //ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
        //    System.out.println(Thread.currentThread().getName());
        //    //暂停几秒钟
        //    try {
        //        Thread.sleep(3000);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //    return "Hello future";
        //},threadPool);
        //System.out.println(completableFuture.get());
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("权力的游戏");
        });

        System.out.println("主线程做其他事情去了");
        completableFuture.join();

        //threadPool.shutdown();
    }
}



