package cn.zyz.juc.atomics;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-09-05 14:31
 **/

public class LongAdderAPIDemo {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        longAdder.increment();
        longAdder.increment();

        System.out.println(longAdder.sum());

        LongAccumulator longAccumulator = new LongAccumulator((x,y)->x+y,0);
        longAccumulator.accumulate(1);//1
        longAccumulator.accumulate(3);//4

        System.out.println(longAccumulator.get());

    }
}



