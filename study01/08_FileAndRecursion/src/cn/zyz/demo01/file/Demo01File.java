package cn.zyz.demo01.file;

import java.io.File;

/**
    static String pathSeparator
    与系统相关的路径分隔符字符，为方便起见，表示为字符串。
    static char pathSeparatorChar
    与系统相关的路径分隔符。
    static String separator
    与系统相关的默认名称分隔符字符，以方便的方式表示为字符串。
    static char separatorChar
    与系统相关的默认名称分隔符。

 */

public class Demo01File {
    public static void main(String[] args) {
        String str1=File.pathSeparator;
        Character char1 = File.pathSeparatorChar;
        System.out.println("路径分隔符字符串格式"+str1);
        System.out.println("路径分隔符字符格式"+char1);
        String str2 = File.separator;
        Character char2 = File.separatorChar;
        System.out.println("名称分隔符字符串格式"+str2);
        System.out.println("名称分隔符字符格式"+char2);

    }
}
