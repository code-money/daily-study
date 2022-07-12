package cn.zyz.sggbase3.java;

public class Singleton2 {
    public static void main(String[] args) {
        Single2 instance1 = Single2.getInstance();
        Single2 instance2 = Single2.getInstance();
        System.out.println(instance1==instance2);
    }
}

//单例设计模式,饿汉式
class Single2{
    //在类装载的时候就进行初始化即为饿汉式
    private static Single2 instance = new Single2();
    public static Single2 getInstance(){
        return instance;
    }
    private Single2() {}

}
