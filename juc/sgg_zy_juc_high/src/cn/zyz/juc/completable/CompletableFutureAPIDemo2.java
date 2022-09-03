package cn.zyz.juc.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-08-28 12:33
 **/

public class CompletableFutureAPIDemo2 {
    public static void main(String[] args) throws Exception {

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2); } catch (Exception e) { e.printStackTrace(); }
            System.out.println("111");
            return 1;
        },threadPool).thenApply(f -> {
            int i =1/0;
            System.out.println("222");
            return f + 2;
        }).thenApply(f -> {
            System.out.println("333");
            return f + 3;
        }).whenComplete((v, e) -> {
            if (e==null){
            System.out.println("计算结果:" + v);
            }
        }).exceptionally(throwable -> {
            throwable.printStackTrace();
            System.out.println(throwable.getMessage());
            return null;
        });
        System.out.println(Thread.currentThread().getName()+"主线程忙其他的去了");

        threadPool.shutdown();
    }
}



