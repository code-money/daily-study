package cn.zyz.demo02.CopyFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @program: study01
 * @author: zyz
 * @create: 2022-07-02 12:39
 **/

//文件复制
public class Demo01CopyFile {
    //字节输入流和字节输出流复制文件较慢
    public static void main(String[] args) throws Exception {
        long begin = System.currentTimeMillis();
        InputStream inputStream = new FileInputStream("09_IOAndProperties\\111.jpg");
        OutputStream outputStream = new FileOutputStream("222.jpg");
        byte[] bytes  = new byte[2048];
        int index = 0;
        int len = 0; //每次读取的有效字节个数
        while ((len = inputStream.read(bytes)) != -1) {
            index++;
            outputStream.write(bytes,0,len);
        }
        long end = System.currentTimeMillis();
        System.out.println(index);
        System.out.println("总共耗时:"+(end-begin)+"毫秒");
    }
}



