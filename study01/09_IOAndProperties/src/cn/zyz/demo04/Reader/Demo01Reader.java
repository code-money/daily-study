package cn.zyz.demo04.Reader;

import java.io.FileReader;
import java.io.Reader;

/**
 * @program: study01
 * @author: zyz
 * @create: 2022-07-02 17:32
 **/

public class Demo01Reader {
    public static void main(String[] args) throws Exception{
//        Reader reader = new FileReader("09_IOAndProperties\\c.txt");
//        int len = 0;
//        while ((len=reader.read())!=-1){
//            System.out.println((char) len);  //每次读取一个字符
//        }

        Reader reader = new FileReader("09_IOAndProperties\\c.txt");
        char[] buffer = new char[1024]; //存储每次读取的字符
        int len = 0;//存储每次读取到的有效字符个数
        while ((len=reader.read(buffer))!=-1){
            System.out.println(buffer);
        }

        reader.close();
    }
}



