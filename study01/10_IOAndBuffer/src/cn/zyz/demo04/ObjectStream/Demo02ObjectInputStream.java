package cn.zyz.demo04.ObjectStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Demo02ObjectInputStream {
    public static void main(String[] args) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("10_IOAndBuffer\\person.txt"));
        //反序列化String对象，注意顺序，先进行序列化的也要先进行反序列化
        String str = (String) ois.readObject();
        //再反序列化Person对象
        Person person =(Person) ois.readObject();
        System.out.println(str);
        System.out.println(person);
        ois.close();
    }
}

