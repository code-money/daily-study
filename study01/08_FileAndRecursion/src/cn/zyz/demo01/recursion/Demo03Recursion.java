package cn.zyz.demo01.recursion;

import java.io.File;
import java.util.Locale;


//递归实现文件过滤
public class Demo03Recursion {
    public static void main(String[] args) {

        File file = new File("D:\\abc");
        paths(file);
    }


    //过滤文件
    //递归打印多级目录，只要指定的文件类型，这里是.java
    private static void paths(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()){
                paths(f);
            }else {
                String name = f.getName();
                if (name.toLowerCase().endsWith(".java")){
                    System.out.println(name);
                }
            }
        }
    }
}
