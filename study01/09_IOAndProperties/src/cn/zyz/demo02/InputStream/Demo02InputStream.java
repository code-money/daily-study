package cn.zyz.demo02.InputStream;

import java.io.*;

/**
 * @program: study01
 * @author: zyz
 * @create: 2022-07-02 12:07
 **/

public class Demo02InputStream {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("09_IOAndProperties\\b.txt");


//        byte bytes[] = new byte[2];
//        int len = inputStream.read(bytes);
//        System.out.println(len);
//        System.out.println(new String(bytes));
//
//        len = inputStream.read(bytes);
//        System.out.println(len);
//        System.out.println(new String(bytes));
//
//        len = inputStream.read(bytes);
//        System.out.println(len);
//        System.out.println(new String(bytes));
//
//        len = inputStream.read(bytes);
//        System.out.println(len);
//        System.out.println(new String(bytes));

        //读取字节数组(缓冲区)，返回的是读取到的有效字节个数，当读取到尾部的时候为-1，并且将数据读到字节数组(缓冲区)中
        byte[] bytes = new byte[2]; //缓冲区
        int len = 0;  //存取读取到的有效字节的个数
        while ((len =inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes));
        }

        inputStream.close();
    }
}



