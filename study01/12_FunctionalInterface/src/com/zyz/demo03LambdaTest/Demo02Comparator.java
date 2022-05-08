package com.zyz.demo03LambdaTest;

import java.util.Arrays;
import java.util.Comparator;

public class Demo02Comparator {
    /*public static Comparator<String> getComparator(){
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        };
    }*/

    /*public static Comparator<String> getComparator(){
        return (String o1,String o2)->{
            return o1.length()-o2.length();
        };
    }*/

    public static Comparator<String> getComparator(){
//        return ( o1, o2)-> o2.length()-o1.length();
        return ( o1, o2)->  o1.length()-o2.length() ;
    }


    public static void main(String[] args) {
        String[] strings= {"f1","ssdfs","111","fffffffff"};
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings,getComparator());
        System.out.println(Arrays.toString(strings));
    }
}
