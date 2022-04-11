package com.zyz.demo02Stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Demo03Stream_filter {
    public static void main(String[] args) {
        Stream<String> values = Stream.of("张三", "李四", "王五", "赵六","张无忌");
        values.filter((name) -> {   //filter方法过滤掉不姓张的姓名
            return name.startsWith("张");
        }).forEach((name)->{        //链式编程遍历输出姓张的人
            System.out.println(name);
        });
        /*
            Stream属于管道流，只能被消费(使用)一次
         */

    }
}
