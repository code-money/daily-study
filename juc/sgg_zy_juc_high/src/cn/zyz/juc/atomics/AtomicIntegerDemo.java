package cn.zyz.juc.atomics;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-09-04 18:26
 **/


class MyNumber {
    AtomicInteger atomicInteger = new AtomicInteger();

    public void increment() {
        atomicInteger.getAndIncrement();

    }
}


public class AtomicIntegerDemo {

    public static final int SIZE = 50;

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(SIZE);
        MyNumber myNumber = new MyNumber();
        for (int i = 0; i < SIZE; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myNumber.increment();
                }
                countDownLatch.countDown();
            }).start();
        }


        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //等待50个线程结束后再获取最终值
        System.out.println(Thread.currentThread().getName() + "\t" + myNumber.atomicInteger);

    }
}



