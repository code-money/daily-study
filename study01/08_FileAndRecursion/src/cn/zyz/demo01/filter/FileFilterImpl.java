package cn.zyz.demo01.filter;

import java.io.File;
import java.io.FileFilter;
import java.util.Locale;

public class FileFilterImpl implements FileFilter {
    /**
     * accept方法用来定义过滤规则
     * @param pathname
     * @return
     */
    @Override
    public boolean accept(File pathname) {
        //当传递的file为.java文件或者传递的是一个文件夹的时候，返回true  否则是false
        return pathname.getName().toLowerCase().endsWith(".java") || pathname.isDirectory();
    }
}
