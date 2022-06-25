package cn.zyz.demo01.file;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 *   路径
 *      绝对路径：完整的路径，以盘符(C、D、E、F)开始
 *      相对路径：简化的路径，相对于当前项目的根目录
 */
public class Demo02File {

    public static void main(String[] args) throws IOException {
//        File file = new File("D:\\a.txt");
//        System.out.println(file);
////        File file1 = new File("D:\\aa");
////        file1.mkdir();
//        File file2 = new File("c.txt");
//        file2.createNewFile();
//        System.out.println(file2.getAbsolutePath());

        File file3 = new File("D:\\aa","c.txt");
        System.out.println(file3);
        System.out.println(file3.exists());
    }
}
