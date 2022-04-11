package com.zyz.demo03Stream;

import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("张三丰", "张无忌", "赵敏", "周芷若", "小昭");
        Stream<String> oneStream=stream1.filter((name)->name.length()==3)
                .limit(2);
        System.out.println("------------------");
        Stream<String> stream2 = Stream.of("张三丰", "张无忌", "赵敏", "周芷若", "小昭","张翠山");
        Stream<String> twoStream=stream2.filter((name)->name.startsWith("张"))
                .skip(2);

        Stream.concat(oneStream, twoStream).map((name)->new Person(name)).forEach(p-> System.out.println(p));
    }

}
