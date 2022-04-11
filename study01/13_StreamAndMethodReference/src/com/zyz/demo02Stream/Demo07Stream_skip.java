package com.zyz.demo02Stream;

import java.util.stream.Stream;

public class Demo07Stream_skip {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("喜羊羊", "美羊羊", "懒洋洋", "灰太狼");
        Stream<String> limit = stream.skip(3);
        limit.forEach((name)->{
            System.out.println(name);
        });
    }
}
