package cn.zyz.juc.demo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-07-12 18:19
 * 题目：现在两个线程，可以操作初始值为0的一个变量
 * 实现一个线程对该变量加1，一个线程对该变量减一
 * 实现交替，来10轮，变量初始值为0
 *
 *  使用Lock和Condition来实现线程控制
 **/
class AirConditioner2 {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment()  {
        lock.lock();
        try {
            while (number != 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number++;
            System.out.println(Thread.currentThread().getName() + ":" + number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void decrement()  {
        lock.lock();
        try {
            while (number == 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            number--;
            System.out.println(Thread.currentThread().getName() + ":" + number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}


public class ThreadWaitNotifyDemo2 {
    public static void main(String[] args) {
        AirConditioner2 air = new AirConditioner2();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                air.increment();
            }
        }, "生产者1").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                air.decrement();
            }
        }, "消费者1").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                air.increment();
            }
        }, "生产者2").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                air.decrement();
            }
        }, "消费者2").start();
    }
}



