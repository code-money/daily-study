package cn.zyz.demo02.InputStream;

import java.io.FileInputStream;
import java.util.Arrays;

public class Demo01InputStream {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("09_IOAndProperties\\a.txt");
        //单个读取
        int read1 = inputStream.read();  //单个读取，返回值是读取到的字节的Ascii码
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        int read4 = inputStream.read();
        int read5 = inputStream.read();
        System.out.println(read1);
        System.out.println(read2);
        System.out.println(read3);
        System.out.println(read4);
        System.out.println(read5);
        inputStream.close();


    }
}
