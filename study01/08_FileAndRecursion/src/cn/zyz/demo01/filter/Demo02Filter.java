package cn.zyz.demo01.filter;

import java.io.File;


//使用FileFilter文件过滤器过滤文件
public class Demo02Filter {
    public static void main(String[] args) {

        File file = new File("D:\\abc");
        paths(file);
    }


    private static void paths(File file) {
        //使用lambada表达式的方式实现匿名内部类，完成文件的过滤
        File[] files = file.listFiles
                ((pathname)-> pathname.getName().toLowerCase().endsWith(".java") || pathname.isDirectory());
        for (File f : files) {
            if (f.isDirectory()){
                paths(f);
            }else {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}
