package cn.zyz.demo01.file;

import java.io.File;
import java.lang.reflect.Field;

public class Demo03File {
    public static void main(String[] args) {
//        show01();
//        show02();
//        show03();
        show04();
    }

    /**
     *   public String getAbsolutePath()：返回此抽象路径名的绝对路径名字符串。
     */
    public static void show01() {
        File file1 = new File("D:\\Ideaworkspace\\daily-study\\study01\\c.txt");
        System.out.println(file1.getAbsolutePath());
        File file2 = new File("c.txt");
        System.out.println(file2.getAbsolutePath());

    }

    /**
     *   public String getPath()：根据构造方法传入的值返回此抽象路径名的路径，构造方法传入绝对路径就返回绝对路径，相对路径就返回相对路径
     *   注：toString()方法就是调用了getPath方法
     */
    public static void show02() {
        File file1 = new File("D:\\Ideaworkspace\\daily-study\\study01\\c.txt");
        System.out.println(file1.getPath());
        File file2 = new File("c.txt");
        System.out.println(file2.getPath());
    }

    /**
     *   public String getName()：返回由此File表示的文件或目录的名称
     *   获取的是传入路径的尾部（文件/文件夹）
     */
    public static void show03() {
        File file1 = new File("D:\\Ideaworkspace\\daily-study\\study01\\c.txt");
        System.out.println(file1.getName());
        File file2 = new File("D:\\Ideaworkspace\\daily-study\\study01");
        System.out.println(file2.getName());
    }

    /**
     *    public Long length()：返回由此file表示的文件长度，以字节为单位
     *    注：
     *      文件夹没有大小概念，无法获得文件夹的大小
     *      如果路径不存在，返回值为0
     */
    public static void show04() {
        File file1 = new File("D:\\Ideaworkspace\\daily-study\\study01\\c.txt");
        System.out.println(file1.length());
    }
}
