package cn.zyz.demo01.file;

import java.io.File;

public class Demo06File {
    public static void main(String[] args) {
        show01();
    }

    private static void show01() {
        File file = new File("D:\\Ideaworkspace\\daily-study\\study01\\08_FileAndRecursion");
        String[] list = file.list();
        File[] files = file.listFiles();
        for (String s : list) {
            System.out.println(s);
        }
        for (File file1 : files) {
            System.out.println(file1);
        }



    }
}
