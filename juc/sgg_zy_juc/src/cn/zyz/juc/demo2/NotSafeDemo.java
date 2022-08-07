package cn.zyz.juc.demo2;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-07-14 12:14
 * <p>
 * 题目：举例说明集合类是不安全的
 *
 * 1.故障现象
 *      java.util.ConcurrentModificationException
 * 2.导致原因
 * 3.解决方案
 *      3.1 Vector
 *      3.2 Collections.synchronizedList(new ArrayList<>())
 *      3.3 CopyOnWriteArrayList
 *          写时复制，CopyOnWrite容器即写时复制的容器。往一个容器添加元素的时候，不直接往当前容器Object[]添加，而是先将当前容器Object[]进行Copy，
 *          复制出一个新的容器Object[] newElements，然后新的容器Object[] newElements里添加元素，添加完元素后，
 *          再将原容器的引用指向新的容器 setArray(newElements);这样做的好处是可以对CopyOnWrite容器进行并发的读，
 *          而不需要枷锁，因为当前容器不会添加任何元素。所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器。
 *
 * 4.优化建议
 **/

public class NotSafeDemo {
    public static void main(String[] args) {
        mapNotSafe();
        listNotSafe();
        setNotSafe();
    }

    public static void mapNotSafe() {
        Map map = new ConcurrentHashMap();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }).start();
        }
    }

    public static void setNotSafe() {
        Set set = new CopyOnWriteArraySet();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }).start();
        }
    }


    public static void listNotSafe() {
        List list = new CopyOnWriteArrayList();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }).start();
        }
    }
}



