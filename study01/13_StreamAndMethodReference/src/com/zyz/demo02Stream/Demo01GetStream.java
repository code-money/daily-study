package com.zyz.demo02Stream;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Demo01GetStream {
    public static void main(String[] args) {
        //1.集合转流
        ArrayList<String> arrayList = new ArrayList();
        Stream<String> stream1 =arrayList.stream();
        //2.Set转流
        Set<String> set = new HashSet();
        Stream<String> stream2=set.stream();

        Map<String,String> map = new HashMap<>();
        //3.Map的Key转流
        Set<String> keySet = map.keySet();
        Stream<String> stream3=keySet.stream();
        //4.Map的Entry转流
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String,String>> stream4=entries.stream();
        //5.Map的value转流
        Collection<String> values = map.values();
        Stream<String> stream5=values.stream();
        //6.数组转流
        Stream<Integer> stream6 = Stream.of(1, 2, 3, 4, 5, 6);
        //7.可变参数可以转数组
        int[] ints = {1,2,3,4,5,6};
        Stream<int[]> stream7 = Stream.of(ints);
    }
}
