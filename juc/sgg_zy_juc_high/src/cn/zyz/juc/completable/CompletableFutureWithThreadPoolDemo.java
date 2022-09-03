package cn.zyz.juc.completable;

import java.util.concurrent.*;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-08-28 14:57
 **/

public class CompletableFutureWithThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            try { TimeUnit.MILLISECONDS.sleep(200);}catch (Exception e){e.printStackTrace();}
            System.out.println("1号任务" + "\t" + Thread.currentThread().getName());
        }, threadPool).thenRunAsync(() -> {
            try { TimeUnit.MILLISECONDS.sleep(20);}catch (Exception e){e.printStackTrace();}
            System.out.println("2号任务" + "\t" + Thread.currentThread().getName());
        }).thenRunAsync(() -> {
            try { TimeUnit.MILLISECONDS.sleep(20);}catch (Exception e){e.printStackTrace();}
            System.out.println("3号任务" + "\t" + Thread.currentThread().getName());
        }).thenRunAsync(() -> {
            try { TimeUnit.MILLISECONDS.sleep(20);}catch (Exception e){e.printStackTrace();}
            System.out.println("4号任务" + "\t" + Thread.currentThread().getName());
        });
        System.out.println(voidCompletableFuture.get());
        threadPool.shutdown();
    }
}



