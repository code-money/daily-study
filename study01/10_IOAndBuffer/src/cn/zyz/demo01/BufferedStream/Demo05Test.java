package cn.zyz.demo01.BufferedStream;

import java.io.*;
import java.util.HashMap;

/**
 * @program: study01
 * @author: zyz
 * @create: 2022-07-03 21:25
 **/
/*
    练习:
        对文本的内容进行排序
        按照(1,2,3....)顺序排序
    分析:
        1.创建一个HashMap集合对象,可以:存储每行文本的序号(1,2,3,..);value:存储每行的文本
        2.创建字符缓冲输入流对象,构造方法中绑定字符输入流
        3.创建字符缓冲输出流对象,构造方法中绑定字符输出流
        4.使用字符缓冲输入流中的方法readline,逐行读取文本
        5.对读取到的文本进行切割,获取行中的序号和文本内容
        6.把切割好的序号和文本的内容存储到HashMap集合中(key序号是有序的,会自动排序1,2,3,4..)
        7.遍历HashMap集合,获取每一个键值对
        8.把每一个键值对,拼接为一个文本行
        9.把拼接好的文本,使用字符缓冲输出流中的方法write,写入到文件中
        10.释放资源
 */
public class Demo05Test {
    public static void main(String[] args) throws Exception{
//        HashMap map = new HashMap();
//        map.put(3,"11");
//        map.put(2,"12");
//        map.put(1,"13");
//        map.forEach((key,value)->{
//            System.out.println(key);
//            System.out.println(value);
//        });
        BufferedReader reader = new BufferedReader(new FileReader("10_IOAndBuffer\\in.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("10_IOAndBuffer\\out.txt"));
        HashMap<Character,String> map = new HashMap();
        String line = "";
        while ((line=reader.readLine())!=null){
            map.put(line.charAt(0),line);
        }
        map.forEach((key,value)->{
            try {
                writer.write(map.get(key));
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        reader.close();
        writer.close();
    }
}



