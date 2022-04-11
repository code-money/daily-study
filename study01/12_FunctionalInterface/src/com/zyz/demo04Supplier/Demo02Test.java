package com.zyz.demo04Supplier;

import java.util.function.Supplier;

public class Demo02Test {
    public static Integer getMax(Supplier<Integer> sup){
        return sup.get();
    }

    public static void main(String[] args) {
        int[] ints = {11,-22,355,42222,50,6,7};
        int num=getMax(()->{
            int max = 0;
            for (int anInt : ints) {
                max=anInt>max ? anInt : max;
            }
            return max;
        });
        System.out.println(num);
    }
}
