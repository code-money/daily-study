package cn.zyz.juc.demo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-07-13 19:11
 * 多线程之间按照顺序调用，实现A->B->C
 * <p>
 * 三个线程启动，要求如下：
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 * ......来10轮
 **/
//资源类
class ShareResource {
    private int number = 1;   //1:A  2:B  3:C
    private transient Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    void showA() {
        lock.lock();
        try {
            while (number != 1) {
                condition1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("AA");
            }
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void showB() {
        lock.lock();
        try {
            while (number != 2) {
                condition2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("BB");
            }
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    void showC() {
        lock.lock();
        try {
            while (number != 3) {
                condition3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println("CC");
            }
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareResource resource = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.showA();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.showB();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                resource.showC();
            }
        }).start();
    }
}



