package cn.zyz.demo01.OutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Demo02OutputStream {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("09_IOAndProperties\\b.txt");
        byte bytes[] = {65,66,67,68,69}; //ABCDE
//        fileOutputStream.write(bytes);
        fileOutputStream.write(bytes,2,2);


        String str = "你好世界";

        fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
        fileOutputStream.close();
    }
}
