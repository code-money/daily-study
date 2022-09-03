package cn.zyz.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-09-03 20:57
 **/

public class ABABDemo {

    static AtomicInteger atomicInteger = new AtomicInteger(100);
    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {
        new Thread(() -> {
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t"+"首次版本号"+stamp);

            try { TimeUnit.MILLISECONDS.sleep( 500);}catch (Exception e){e.printStackTrace();}

            stampedReference.compareAndSet(100,101,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t"+"2次版本号"+stampedReference.getStamp());

            stampedReference.compareAndSet(101,100,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t"+"3次版本号"+stampedReference.getStamp());
        },"t3").start();

        new Thread(() -> {
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t"+"首次版本号"+stamp);

            //等待t3线程发生aba问题
            try { TimeUnit.MILLISECONDS.sleep( 1000);}catch (Exception e){e.printStackTrace();}

            boolean b = stampedReference.compareAndSet(100, 2022, stamp, stamp + 1);
            System.out.println(b+"\t"+stampedReference.getReference()+"\t"+stampedReference.getStamp());
        },"t4").start();
    }

    private static void abaHappen() {
        new Thread(() -> {
            atomicInteger.compareAndSet(100,101);
            //暂停一下
            try { TimeUnit.MILLISECONDS.sleep(10 );}catch (Exception e){e.printStackTrace();}
            atomicInteger.compareAndSet(101,100);
        },"t1").start();

        new Thread(() -> {
            try { TimeUnit.MILLISECONDS.sleep(200 );}catch (Exception e){e.printStackTrace();}
            System.out.println(atomicInteger.compareAndSet(100,2022)+"\t"+atomicInteger.get());
        },"t2").start();
    }
}



