package cn.zyz.juc.demo2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-07-15 15:58
 **/


class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    ReadWriteLock readWriteLock =new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t写入数据");
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace();}
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t写入完成");
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t读取数据");
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t读取完成"+o);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache cache = new MyCache();
        for (int i = 0; i < 5; i++) {
            int tempInt = i;
            new Thread(() -> {
                cache.put(tempInt+"",tempInt+"");
            },"-----写线程"+i).start();
        }
        for (int i = 0; i < 5; i++) {
            int tempInt = i;
            new Thread(() -> {
                cache.get(tempInt+"");
            },"读线程"+i).start();
        }
    }
}



