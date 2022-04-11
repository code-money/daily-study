package com.zyz.demo01Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

/*
*   Stream流学习
*
* */
public class Demo02Stream {
    public static void main(String[] args) {
        ArrayList<String>  list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        list.add("韩七");
        list.add("张三丰");
        list.add("张无忌");
        //过滤 只要张开头
        //过滤 只要三个字的名字的人
        list.stream()
                .filter(name->name.startsWith("张"))
                .filter(name->name.length()==3)
                .forEach(name-> System.out.println(name));
        int[] ints = {1,2,3,3,4};
        Stream<int[]> ints1 = Stream.of(ints);
    }
}
