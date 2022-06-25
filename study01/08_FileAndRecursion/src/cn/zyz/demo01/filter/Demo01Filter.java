package cn.zyz.demo01.filter;

import java.io.File;



//使用FileFilter文件过滤器过滤文件
public class Demo01Filter {
    public static void main(String[] args) {

        File file = new File("D:\\abc");
        paths(file);
    }


    private static void paths(File file) {
        //调用FileFilter的实现类，用来过滤文件
        File[] files = file.listFiles(new FileFilterImpl());
        for (File f : files) {
            if (f.isDirectory()){
                paths(f);
            }else {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}
