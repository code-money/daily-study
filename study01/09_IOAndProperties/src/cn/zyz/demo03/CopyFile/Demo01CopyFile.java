package cn.zyz.demo03.CopyFile;

import java.io.*;

/**
 * @program: study01
 * @author: zyz
 * @create: 2022-07-02 12:39
 **/

//文件复制
public class Demo01CopyFile {
    public static void main(String[] args) throws Exception {


        InputStream inputStream = new FileInputStream("09_IOAndProperties\\111.jpg");
        OutputStream outputStream = new FileOutputStream("222.jpg");
        byte[] bytes = new byte[2048];
        int len = 0; //每次读取的有效字节个数
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
            outputStream.close();
            inputStream.close();

        }
    }
}



