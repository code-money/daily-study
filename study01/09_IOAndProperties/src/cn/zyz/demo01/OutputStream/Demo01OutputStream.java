package cn.zyz.demo01.OutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @program: study01
 * @author: zyz
 * @create: 2022-06-25 20:21
 **/

public class Demo01OutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("09_IOAndProperties\\a.txt");
        fileOutputStream.write(97);
        fileOutputStream.write(98);
        fileOutputStream.close();
    }
}



