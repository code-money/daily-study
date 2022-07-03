package cn.zyz.demo05.Writer;

import java.io.FileWriter;
import java.io.Writer;

/**
 * @program: study01
 * @author: zyz
 * @create: 2022-07-02 18:02
 **/

//       flush：把内存缓冲区中的数据刷新到文件中，使用该方法后流仍然可以使用
//       close：首先调用flush方法，然后再关闭字符输出流，关闭后流不可用
public class Demo02FlushAndClose {
    public static void main(String[] args) throws Exception{
        Writer writer = new FileWriter("09_IOAndProperties\\d.txt");
        writer.write('a');
        writer.write('b');
        writer.flush();
        writer.write('c');
        writer.write('d');
        writer.close();
        writer.write('e');
    }
}



