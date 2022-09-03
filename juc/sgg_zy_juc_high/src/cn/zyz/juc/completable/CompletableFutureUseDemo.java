package cn.zyz.juc.completable;

import java.util.concurrent.*;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-08-27 16:24
 **/

public class CompletableFutureUseDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+"------come in");
            int result = ThreadLocalRandom.current().nextInt(10);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("一秒后出结果");
            if (result%2==0){
                throw new RuntimeException("自定义异常");
            }
            return result;
        },threadPool).whenComplete((v,e)->{
            if (e==null){
                System.out.println("----计算完成，更新系统UpdateValue:"+v);
            }
        }).exceptionally(e->{
            e.printStackTrace();
            System.out.println("异常情况"+e.getCause()+"\t"+e.getMessage());
            return null;
        });
        System.out.println(Thread.currentThread().getName()+"线程先去忙其他的了");
        //主进程不要立即结束，否则CompletableFuture默认使用的线程池会立刻关闭，类似于守护线程那样，这里暂停三秒钟
        //try { TimeUnit.SECONDS.sleep(3);}catch (Exception e){e.printStackTrace();}
        threadPool.shutdown();
    }

    private static void future1() throws InterruptedException, ExecutionException {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+"------come in");
            int result = ThreadLocalRandom.current().nextInt(10);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("一秒后出结果");
            return result;
        });

        System.out.println(Thread.currentThread().getName()+"线程先去忙其他的了");

        System.out.println(completableFuture.get());
    }
}



