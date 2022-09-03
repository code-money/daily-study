package cn.zyz.juc.completable;

import java.util.concurrent.CompletableFuture;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-08-28 14:32
 **/

public class CompletableFutureAPIDemo3 {
    public static void main(String[] args) {
        //CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
        //    return 1;
        //}).thenApply(f -> {
        //    return f + 2;
        //}).thenApply(f -> {
        //    return f + 3;
        //}).thenAccept(r -> {
        //    System.out.println(r);
        //});
        //System.out.println(completableFuture.join());

        System.out.println(CompletableFuture.supplyAsync(()->"resultA").thenRun(()->{}).join());
        System.out.println(CompletableFuture.supplyAsync(()->"resultA").thenAccept(f->{System.out.println(f);}).join());
        System.out.println(CompletableFuture.supplyAsync(()->"resultA").thenApply(f->f+"resultB").join());

    }
}



