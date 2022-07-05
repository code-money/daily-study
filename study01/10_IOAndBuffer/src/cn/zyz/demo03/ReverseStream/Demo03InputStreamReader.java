package cn.zyz.demo03.ReverseStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Demo03InputStreamReader {
    public static void main(String[] args) throws Exception{
        reader_utf8();
        reader_gbk();
    }

    private static void reader_gbk() throws Exception{
        InputStreamReader reader  = new InputStreamReader(new FileInputStream("10_IOAndBuffer\\gbk.txt"),"gbk");
        int len =0;
        while ((len=reader.read())!=-1){
            System.out.print((char) len);
        }
        reader.close();
    }

    private static void reader_utf8() throws Exception{
        InputStreamReader reader  = new InputStreamReader(new FileInputStream("10_IOAndBuffer\\utf8.txt"),"utf8");
        int len =0;
        while ((len=reader.read())!=-1){
            System.out.print((char) len);
        }
        reader.close();
    }
}
