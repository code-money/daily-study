package cn.zyz.demo01.recursion;

import java.io.File;
import java.lang.reflect.Field;


//文件遍历
public class Demo02Recursion {
    public static void main(String[] args) {

        File file = new File("D:\\abc");
        paths(file);
    }


    //递归打印多级目录
    private static void paths(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f.getAbsolutePath());
            if (f.isDirectory()){
                paths(f);
            }
        }
    }
}
