package cn.zyz.demo01.file;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;


/**
 *
 *  public boolean createNewFile() throws IOException：当且仅当具有该名称的文件不存在时，创建一个新的空文件
 *  返回值：布尔类型
 *      true：文件不存在，创建文件，返回true
 *      false：文件存在，不做更改，返回false
 *  注意：
 *      此方法只能创建文件不能创建文件夹
 *      创建文件的路径必须存在，否则会抛出异常
 *
 *  public boolean mkdir()：创建文件夹
 *  返回值：布尔类型
 *      true：文件夹不存在，创建文件夹，返回true
 *      false：文件夹存在，返回false；构造方法给出的路径不存在，返回false
 *  注意
 *      此方法只能创建文件夹，不能创建文件
 *
 *  public boolean delete()：删除文件/文件夹
 */
public class Demo05File {
    public static void main(String[] args) throws Exception {
//        show01();
//        show02();
//        show03();
    }

    private static void show03() {
        File file = new File("D:\\Ideaworkspace\\daily-study\\study01\\c.txt");
        boolean delete = file.delete();
        System.out.println(delete);
    }

    private static void show02() {
        File  file = new File("D:\\aa");
        boolean mkdir = file.mkdir();
        System.out.println(mkdir);


        File f2 = new File("D:\\aa\\bb\\cc\\dd");
        boolean mkdirs = f2.mkdirs();
        System.out.println(mkdirs);
    }

    private static void show01() throws IOException {
        File file = new File("D:\\Ideaworkspace\\daily-study\\study01\\08_FileAndRecursion\\a.txt");
        boolean flag = file.createNewFile();
        System.out.println(flag);

    }
}
