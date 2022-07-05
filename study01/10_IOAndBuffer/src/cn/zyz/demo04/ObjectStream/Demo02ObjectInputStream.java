package cn.zyz.demo04.ObjectStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Demo02ObjectInputStream {
    public static void main(String[] args) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("10_IOAndBuffer\\person.txt"));
        Object o = ois.readObject();
        System.out.println(o);
        ois.close();
    }
}

