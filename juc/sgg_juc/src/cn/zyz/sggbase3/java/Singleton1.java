package cn.zyz.sggbase3.java;

public class Singleton1 {
    public static void main(String[] args) {
        Single1 instance1 = Single1.getInstance();
        Single1 instance2 = Single1.getInstance();
        System.out.println(instance1==instance2);
    }
}
//单例设计模式,懒汉式
class Single1{
    private static Single1 instance;
    //在类初始化的时候才进行初始化即为懒汉式
    public static Single1 getInstance(){
        if (instance==null){
            instance = new Single1();
        }
        return instance;
    }
    //单例模式关键在于私有化构造器，并且声明一个当前类的类变量来控制单例。
    private Single1() {}

}
