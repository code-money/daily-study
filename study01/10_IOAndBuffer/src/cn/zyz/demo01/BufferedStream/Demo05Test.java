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
 */
public class Demo05Test {
    public static void main(String[] args) throws Exception{

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



