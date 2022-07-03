package cn.zyz.demo05.Writer;

import java.io.FileWriter;
import java.io.Writer;

/**
 * @program: study01
 * @author: zyz
 * @create: 2022-07-02 17:51
 **/

/*
    字符输出流
    与字节输出流不同为，字节输出流是写到文件中，字符输出流是写到内存缓冲区中转换为字节
    flush方法：把内存缓冲区中的数据刷新到文件中，使用该方法后流仍然可以使用
    close方法：首先调用flush方法，然后再关闭字符输出流
 */
public class Demo01Writer {
    public static void main(String[] args) throws Exception{
        Writer writer = new FileWriter("09_IOAndProperties\\d.txt");
        char c = 99;
        writer.write(c);
        writer.close();
    }
}



