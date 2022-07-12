package cn.zyz.sggbase3.java;


import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式
 */
public class LockTest {
    public static void main(String[] args) {
        Window window = new Window();
        new Thread(window, "线程1").start();
        new Thread(window, "线程2").start();
        new Thread(window, "线程3").start();
    }
}

class Window implements Runnable {
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();//调用锁定方法
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;
                    continue;
                }
                break;
            } finally {
                lock.unlock();//调用解锁方法
            }
        }
    }
}
