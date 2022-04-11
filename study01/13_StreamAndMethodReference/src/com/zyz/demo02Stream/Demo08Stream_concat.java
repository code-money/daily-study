package com.zyz.demo02Stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Demo08Stream_concat {
    public static void main(String[] args) {
        String[] strings ={"喜羊羊", "美羊羊", "懒洋洋", "灰太狼"};
        Stream stream1=Arrays.stream(strings);
        Stream<String> stream2 = Stream.of("张三", "李四", "王五", "赵六","张无忌");
        Stream.concat(stream1, stream2).forEach((name)-> System.out.println(name));
    }
}
