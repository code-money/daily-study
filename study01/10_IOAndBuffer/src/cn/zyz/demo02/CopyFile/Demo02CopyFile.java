package cn.zyz.demo02.CopyFile;

import java.io.*;

/**
 * @program: study01
 * @author: zyz
 * @create: 2022-07-02 12:39
 **/

//文件复制
public class Demo02CopyFile {
    public static void main(String[] args) throws Exception {
        long begin = System.currentTimeMillis();
        BufferedInputStream bis =  new BufferedInputStream(new FileInputStream("09_IOAndProperties\\111.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("222.jpg"));
        byte[] bytes  = new byte[2048];
        int index = 0;
        int len = 0; //每次读取的有效字节个数
        while ((len = bis.read(bytes)) != -1) {
            index++;
            bos.write(bytes,0,len);
        }
        long end = System.currentTimeMillis();
        System.out.println(index);
        System.out.println("总共耗时:"+(end-begin)+"毫秒");
        bos.close();
        bis.close();
    }
}



