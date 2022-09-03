package cn.zyz.juc.cas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-09-03 18:22
 **/
@Getter
@ToString
@AllArgsConstructor
class User{
    String userName;
    int    age;
}

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        AtomicReference<User> atomicReference = new AtomicReference<>();
        User u1 = new User("张三", 20);
        User u2 = new User("李四", 10);

        atomicReference.set(u1);

        System.out.println(atomicReference.compareAndSet(u1,u2)+"\t"+atomicReference.get());
        System.out.println(atomicReference.compareAndSet(u1,u2)+"\t"+atomicReference.get());
    }
}



