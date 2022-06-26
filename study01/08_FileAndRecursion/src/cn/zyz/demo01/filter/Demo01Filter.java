package cn.zyz.demo01.filter;

import java.io.File;



//使用FileFilter文件过滤器过滤文件
public class Demo01Filter {
    public static void main(String[] args) {

        File file = new File("D:\\abc");
        paths(file);
    }


    private static void paths(File file) {
        //调用FileFilter(Filter的实现类)作为参数，过滤文件
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
