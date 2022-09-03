package cn.zyz.juc.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-08-28 12:33
 **/

public class CompletableFutureAPIDemo {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            //暂停几秒钟
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "abc";
        });

        //System.out.println(completableFuture.get());
        //System.out.println(completableFuture.get(2L,TimeUnit.SECONDS));
        //System.out.println(completableFuture.join());
        //try { TimeUnit.SECONDS.sleep(3);}catch (Exception e){e.printStackTrace();}

        //在计算没有完成的情况下，返回一个代替的结果，也就是传入的参数
        //System.out.println(completableFuture.getNow("xxx"));

        System.out.println(completableFuture.complete("completeValue")+"\t"+completableFuture.join());
    }
}



