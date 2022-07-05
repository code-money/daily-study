package cn.zyz.demo04.ObjectStream;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

//作用：把对象以流的方式写入到文件中保存
public class Demo01ObjectOutputStream {
    public static void main(String[] args) throws Exception{
        Person person = new Person("张三",18);
        ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("10_IOAndBuffer\\person.txt"));
        oot.writeObject(person);
        oot.close();
    }
}

