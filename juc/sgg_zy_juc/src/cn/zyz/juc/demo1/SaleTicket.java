package cn.zyz.juc.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


//卖票案例
class Ticket {
    private int number = 30;
    private transient Lock lock = new ReentrantLock();

    public void saleTicket() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第" + (30 - (--number)) + "张票" + "还剩下" + number + "张票");
            }
        } finally {
            lock.unlock();
        }
    }
}

public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.saleTicket();
            }
        }, "张三").start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.saleTicket();
            }
        }, "李四").start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                ticket.saleTicket();
            }
        }, "王五").start();
    }
}
