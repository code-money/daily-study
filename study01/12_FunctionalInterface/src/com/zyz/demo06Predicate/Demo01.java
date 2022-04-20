package com.zyz.demo06Predicate;

import java.util.function.Predicate;

public class Demo01 {
    public static boolean method(String name, Predicate<String> predicate){
        return predicate.test(name);
    }

    public static void main(String[] args) {
        int a=1;
        boolean flag=method("lakjdlkfja",(t)->{
            return t.length()>5;
        });
        System.out.println(flag);
    }
}
