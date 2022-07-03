package cn.zyz.demo05.Writer;

import java.io.FileWriter;
import java.io.Writer;

/**
 * @program: study01
 * @author: zyz
 * @create: 2022-07-02 18:03
 **/

public class Demo03Writer {
    public static void main(String[] args) throws Exception{
        Writer writer = new FileWriter("09_IOAndProperties\\d.txt");
        char[] chars = {'a','b','c','d','e'};
        writer.write(chars);
        writer.write(chars,1,3);
        writer.write("你好世界");
        writer.close();
    }
}



