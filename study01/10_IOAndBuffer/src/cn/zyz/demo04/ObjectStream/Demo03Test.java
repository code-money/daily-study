package cn.zyz.demo04.ObjectStream;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

//序列化集合
public class Demo03Test {
    public static void main(String[] args) throws Exception{
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("张三",1));
        list.add(new Person("张三",2));
        list.add(new Person("张三",3));
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("10_IOAndBuffer\\list.txt"));
        outputStream.writeObject(list);
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("10_IOAndBuffer\\list.txt"));
        ArrayList<Person> arrayList =(ArrayList<Person>) inputStream.readObject();
        for (Person person : arrayList) {
            System.out.println(person);
        }
        inputStream.close();
        outputStream.close();
    }
}
