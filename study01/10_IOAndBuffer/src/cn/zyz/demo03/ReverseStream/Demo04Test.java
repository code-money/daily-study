package cn.zyz.demo03.ReverseStream;

import java.io.*;

//将GBK编码文件转换为UTF-8编码文件
public class Demo04Test {
    public static void main(String[] args) throws Exception{
        InputStreamReader reader = new InputStreamReader(new FileInputStream("10_IOAndBuffer\\test_gbk.txt"),"gbk");
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("10_IOAndBuffer\\test_utf8.txt"),"utf8");
        char[] buffer = new char[2048];
        int len=0;
        while ((len=reader.read(buffer))!=-1){
            writer.write(buffer,0,len);
        }
        writer.close();;
        reader.close();
    }
}
