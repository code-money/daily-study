package cn.zyz.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-09-03 18:29
 **/


/**
 * 手写自旋锁
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t"+"come in");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void unLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\t"+"task over,unLock");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLock = new SpinLockDemo();
        new Thread(() -> {
            spinLock.lock();
            try { TimeUnit.SECONDS.sleep( 3);}catch (Exception e){e.printStackTrace();}
            spinLock.unLock();
        },"A").start();

        try { TimeUnit.MILLISECONDS.sleep(500 );}catch (Exception e){e.printStackTrace();}

        new Thread(() -> {
            spinLock.lock();
            spinLock.unLock();
        },"B").start();
    }
}



