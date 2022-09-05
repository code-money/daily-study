package cn.zyz.juc.atomics;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-09-05 15:54
 **/

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * 需求：50个线程，每个线程100w次，总点赞数显示出来
 */
class ClickNumber {
    int number = 0;

    public synchronized void clickBySynchronized() {
        number++;
    }

    AtomicLong atomicLong = new AtomicLong();

    public void clickByAtomicLong() {
        atomicLong.incrementAndGet();
    }

    LongAdder longAdder = new LongAdder();

    public void clickByLongAdder() {
        longAdder.increment();
    }

    LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x + y, 0);

    public void clickByLongAccumulator() {
        longAccumulator.accumulate(1);
    }

}

public class AccumulatorCompareDemo {

    public static final int THREAD_SIZE = 50;
    public static final int LIKE_SIZE = 10000;

    public static void main(String[] args) throws Exception{
        ClickNumber clickNumber = new ClickNumber();
        CountDownLatch countDownLatch1 = new CountDownLatch(THREAD_SIZE);
        CountDownLatch countDownLatch2 = new CountDownLatch(THREAD_SIZE);
        CountDownLatch countDownLatch3 = new CountDownLatch(THREAD_SIZE);
        CountDownLatch countDownLatch4 = new CountDownLatch(THREAD_SIZE);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < THREAD_SIZE; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 10 * LIKE_SIZE; j++) {
                        clickNumber.clickBySynchronized();
                    }
                } finally {
                    countDownLatch1.countDown();
                }
            }).start();
        }
        countDownLatch1.await();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime+"\t"+ clickNumber.number);

        startTime=System.currentTimeMillis();
        for (int i = 0; i < THREAD_SIZE; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 10 * LIKE_SIZE; j++) {
                        clickNumber.clickByAtomicLong();
                    }
                } finally {
                    countDownLatch2.countDown();
                }
            }).start();
        }
        countDownLatch2.await();
        endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime+"\t"+clickNumber.atomicLong);

        startTime=System.currentTimeMillis();
        for (int i = 0; i < THREAD_SIZE; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 10 * LIKE_SIZE; j++) {
                        clickNumber.clickByLongAdder();
                    }
                } finally {
                    countDownLatch3.countDown();
                }
            }).start();
        }
        countDownLatch3.await();
        endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime+"\t"+clickNumber.longAdder);

        startTime=System.currentTimeMillis();
        for (int i = 0; i < THREAD_SIZE; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 10 * LIKE_SIZE; j++) {
                        clickNumber.clickByLongAccumulator();
                    }
                } finally {
                    countDownLatch4.countDown();
                }
            }).start();
        }
        countDownLatch4.await();
        endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime+"\t"+clickNumber.longAccumulator);
    }
}



