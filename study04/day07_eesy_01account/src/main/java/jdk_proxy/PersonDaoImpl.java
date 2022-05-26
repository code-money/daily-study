package jdk_proxy;

public class PersonDaoImpl implements PersonDao{
    @Override
    public void method(String name) {
        System.out.println("这是一个人类:"+name);
    }

    @Override
    public void play(String some) {
        System.out.println("正在玩:"+some);
    }
}
