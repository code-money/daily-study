package com.zyz.demo02Stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Demo05Stream_count {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("111");
        arrayList.add("111");
        arrayList.add("111");
        arrayList.add("111");
        arrayList.add("111");
        Stream<String> stream=arrayList.stream();
        long count = stream.count();
        System.out.println(count);
    }
}
