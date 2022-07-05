package cn.zyz.demo03.ReverseStream;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 *   读取UTF-8不会乱码
 *   读取GBK会产生乱码
 */
public class Demo01 {
    public static void main(String[] args) throws Exception{
        FileReader reader = new FileReader("10_IOAndBuffer\\我是GBK格式的文本.txt");
        int len =0;
        while ((len=reader.read())!=-1){
            System.out.print((char) len);
        }
        reader.close();
    }
}
