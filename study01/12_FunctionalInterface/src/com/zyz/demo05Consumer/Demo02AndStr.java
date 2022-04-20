package com.zyz.demo05Consumer;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.util.Locale;
import java.util.function.Consumer;

public class Demo02AndStr {
    public static void method(String str, Consumer<String> c1, Consumer<String> c2){
//        c1.accept(str);
//        c2.accept(str);
        c2.andThen(c1).accept(str);
    }

    public static void main(String[] args) {
        int a=1;
        method("Hello",
                (t)->{
                    System.out.println(t.toLowerCase());
                },
                (t)->{
                    System.out.println(t.toUpperCase());
                });
    }
}
