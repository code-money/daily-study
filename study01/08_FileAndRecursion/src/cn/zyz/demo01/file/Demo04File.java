package cn.zyz.demo01.file;

import java.io.File;

public class Demo04File {
    /*
            public boolean exists()：判断当前file表示的文件或目录是否存在
            public boolean isDirectory()：判断当前file是否为一个目录(文件夹)
            注：如果当前文件夹不存在也会返回false，在使用前一般要判断文件夹是否存在
            public boolean isFile()：判断当前file是否为一个文件
     */
    public static void main(String[] args) {
//        show1();
        show2();
    }

    public static void show1(){
        File file1 = new File("D:\\Ideaworkspace\\daily-study\\study01\\c.txt");
        File file2 = new File("D:\\Ideaworkspace\\daily-study\\study01\\e.txt");
        System.out.println(file1.exists());
        System.out.println(file2.exists());
    }

    public static void show2(){
        File file1 = new File("D:\\Ideaworkspace\\daily-study\\study01\\c.txt");
        File file2 = new File("D:\\Ideaworkspace\\daily-study\\study01");
        System.out.println(file1.isDirectory());
        System.out.println(file2.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file2.isFile());
    }
}
