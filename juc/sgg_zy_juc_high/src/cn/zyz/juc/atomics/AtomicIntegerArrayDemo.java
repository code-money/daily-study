package cn.zyz.juc.atomics;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-09-04 21:14
 **/

public class AtomicIntegerArrayDemo {
    public static void main(String[] args) {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[5]);
        //AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(5);
        //AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[]{1,2,3,4,5});

        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            System.out.println(atomicIntegerArray.get(i));
            atomicIntegerArray.set(i,i);
        }
        int oldN=0;

        //参数为索引值和要改为的数值
        oldN = atomicIntegerArray.getAndSet(0, 1122);
        System.out.println(oldN+"\t"+atomicIntegerArray.get(0));

        //参数为索引值
        oldN=atomicIntegerArray.getAndIncrement(0);
        System.out.println(oldN+"\t"+atomicIntegerArray.get(0));
    }
}



