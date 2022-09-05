package cn.zyz.juc.atomics;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-09-05 18:25
 **/

public class Test {
    public static void main(String[] args) {
        System.out.println(1&1);
        System.out.println(1&0);
        System.out.println(0&1);
        System.out.println(0&0);
    }
}



