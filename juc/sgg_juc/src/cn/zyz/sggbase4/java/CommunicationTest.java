package cn.zyz.sggbase4.java;


/**
 * 线程通信举例
 * 两个线程交替输出
 * wait()方法:线程进入阻塞态,抛出锁
 * sleep()方法:设置当前线程阻塞一定时间,不抛出锁
 * notify()方法:唤醒被wait()的线程,如果有多个被wait,那么唤醒优先级高的
 * notifyAll()方法:唤醒所有被wait()的线程
 */
public class CommunicationTest {
    public static void main(String[] args) {
        Number number = new Number();
        new Thread(number,"线程1").start();
        new Thread(number,"线程2").start();
    }
}

class Number implements Runnable {
    private int i = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notifyAll();
                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                break;
            }
        }
    }
}
