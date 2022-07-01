package cn.zyz.demo02.InputStream;

import java.io.FileInputStream;
import java.util.Arrays;

public class Demo01InputStream {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("09_IOAndProperties\\b.txt");
        //单个读取
//        int read1 = inputStream.read();  //单个读取，返回值是读取到的字节的Ascii码
//        int read2 = inputStream.read();
//        int read3 = inputStream.read();
//        System.out.println(read1);
//        System.out.println(read2);
//        System.out.println(read3);
//        inputStream.close();

        byte bytes[] = new byte[2];
        int len = inputStream.read(bytes);
        len = inputStream.read(bytes);
        System.out.println(len);
        System.out.println(new String(bytes));

        int len2 = inputStream.read(bytes);
        System.out.println(len);
        System.out.println(new String(bytes));

        int len3 = inputStream.read(bytes);
        System.out.println(len);
        System.out.println(new String(bytes));

        int len4 = inputStream.read(bytes);
        System.out.println(len);
        System.out.println(new String(bytes));

        //读取字节数组，返回的是读取到的数据的字节总数，并且将数据读到字节数组(缓冲区)中
//        byte buffer[] = new byte[1024];
//        int len =0;
//        while ((len=inputStream.read(buffer))!=-1) {
//            System.out.println(new String(buffer));
//        }

        inputStream.close();
    }
}
