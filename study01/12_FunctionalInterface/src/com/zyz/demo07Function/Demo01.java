package com.zyz.demo07Function;

import java.util.function.Function;

public class Demo01 {
    public static void method(String str, Function<String,Integer> fun){
        Integer ints = fun.apply(str);
        System.out.println(ints);
    }

    public static void main(String[] args) {
        method("111",(str)->{
            return Integer.parseInt(str);
        });
        method("222", new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return null;
            }
        });
    }
}
