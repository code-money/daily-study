package cn.zyz.juc.demo2;

import java.util.concurrent.CyclicBarrier;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-07-15 09:22
 **/

/**
 *  循环栅栏
 *  CyclicBarrier
 *  的字面意思是可循环（Cyclic）使用的屏障（Barrier）。它要做的事情是，
 *  让一组线程到达一个屏障（也可以叫同步点）时被阻塞，
 *  直到最后一个线程到达屏障时，屏障才会开门，所有
 *  被屏障拦截的线程才会继续干活。
 *  线程进入屏障通过CyclicBarrier的await()方法。
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("集齐7颗龙珠,召唤神龙");
        });
        for (int i = 1; i <= 7; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println("收集到第"+ finalI +"颗龙珠");
                try{
                    cyclicBarrier.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            },Integer.toString(i)).start();
        }
    }
}



