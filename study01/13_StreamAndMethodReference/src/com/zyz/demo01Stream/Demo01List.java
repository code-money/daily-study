package com.zyz.demo01Stream;

import java.util.ArrayList;

public class Demo01List {
    public static void main(String[] args) {
        ArrayList<String>  list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        list.add("韩七");
        list.add("张三丰");
        list.add("张无忌");
        //过滤  只要张开头的人
        ArrayList<String> listA = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("张")){
                listA.add(s);
            }
        }

        //只要名字长度为3的人
        ArrayList<String> listB = new ArrayList<>();
        for (String s : listA) {
            if (s.length()==3){
                listB.add(s);
                System.out.println(s);
            }
        }
    }
}
