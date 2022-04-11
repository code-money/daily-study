package com.zyz.demo02Stream;

import java.util.stream.Stream;

public class Demo04Stream_map {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("1", "2", "3", "4");
        stream.map((String str)->{
            return Integer.parseInt(str);
        }).forEach((str)-> System.out.println(str));
    }
}
