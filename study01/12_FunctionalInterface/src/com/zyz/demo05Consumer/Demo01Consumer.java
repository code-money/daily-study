package com.zyz.demo05Consumer;

import java.util.function.Consumer;

public class Demo01Consumer {
    public static void method(String name, Consumer consumer) {
        consumer.accept(name);
    }

    public static void main(String[] args) {
        System.out.println("------");
        method("飞流",(name)->{
            System.out.println(name);
            String reName = new StringBuffer((String) name).reverse().toString();
            System.out.println(reName);
        });
        //探究运行顺序，不采用内部类的方式，采用写一个类继承Consumer接口来探究运行顺序
//        method("飞流",new Tes());
    }
}
