package cn.zyz.demo03.ReverseStream;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;



public class Demo02OutputStreamWriter {
    public static void main(String[] args) throws Exception{
        write_utf8();
        write_gbk();

    }

    private static void write_gbk() throws Exception{
        OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream("10_IOAndBuffer\\gbk.txt"),"gbk");
        streamWriter.write("你好");
        streamWriter.close();
    }

    private static void write_utf8() throws Exception{
        OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream("10_IOAndBuffer\\utf8.txt"),"utf8");
        streamWriter.write("你好");
        streamWriter.close();
    }
}
