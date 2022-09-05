package cn.zyz.juc.atomics;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-09-04 21:34
 **/

public class AtomicMarkableReferenceDemo {
        static AtomicMarkableReference markableReference = new AtomicMarkableReference(100,false);
    public static void main(String[] args) {
        new Thread(() -> {
            boolean marked = markableReference.isMarked();
            System.out.println(Thread.currentThread().getName()+"\t"+"默认标识"+marked);

            //等待t2拿到默认标识
            try { TimeUnit.SECONDS.sleep( 1);}catch (Exception e){e.printStackTrace();}

            markableReference.compareAndSet(100,101,marked,!marked);
        }).start();

        new Thread(() -> {
            boolean marked = markableReference.isMarked();
            System.out.println(Thread.currentThread().getName()+"\t"+"默认标识"+marked);

            try { TimeUnit.SECONDS.sleep( 2);}catch (Exception e){e.printStackTrace();}

            boolean b = markableReference.compareAndSet(101, 102, marked, !marked);
            System.out.println(Thread.currentThread().getName()+"\t"+"t2线程CASResult"+b);
            System.out.println(Thread.currentThread().getName()+markableReference.isMarked());
            System.out.println(Thread.currentThread().getName()+markableReference.getReference());
        }).start();
    }
}



