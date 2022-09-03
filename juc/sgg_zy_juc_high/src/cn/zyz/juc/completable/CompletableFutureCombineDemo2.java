package cn.zyz.juc.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-08-28 16:01
 **/

public class CompletableFutureCombineDemo2 {
    public static void main(String[] args) {
        Integer join = CompletableFuture.supplyAsync(() -> {
            try { TimeUnit.SECONDS.sleep(2);}catch (Exception e){e.printStackTrace();}
            System.out.println(Thread.currentThread().getName()+"\t"+"----com in 1");
            return 10;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+"\t"+"----com in 2");
            return 20;
        }), (x, y) -> {
            System.out.println(Thread.currentThread().getName()+"\t"+"----com in 3");
            return x + y;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+"\t"+"----com in 4");
            return 30;
        }), (x, y) -> {
            System.out.println(Thread.currentThread().getName()+"\t"+"----com in 5");
            return x+y;
        }).join();

        System.out.println("主线程忙其他事情");
        System.out.println(join);
    }
}



