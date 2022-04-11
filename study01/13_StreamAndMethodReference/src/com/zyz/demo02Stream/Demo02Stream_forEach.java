package com.zyz.demo02Stream;

import java.util.stream.Stream;

public class Demo02Stream_forEach {
    public static void main(String[] args) {
        Stream<String> values = Stream.of("张三", "李四", "王五", "赵六");
        //stream的foreach方法为终结方法，用完该方法后能再调用其他方法
        values.forEach((name)->{
            System.out.println(name);
        });

    }
}
