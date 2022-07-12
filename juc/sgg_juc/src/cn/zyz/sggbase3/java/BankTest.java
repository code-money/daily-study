package cn.zyz.sggbase3.java;

public class BankTest {

}

/*
    在多线程环境下执行到 if (instance==null) 时,可能会有多个线程进入到赋值语句，此时可能会产生不同的instance实例对象,违背了单例模式的原则
    使用同步机制将懒汉式单例模式改为线程安全的
 */
class Bank{
    private static Bank instance;
    private static  Bank getInstance(){
        //使用双重检查锁将单例模式懒汉式优化为线程安全的
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance==null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
    private Bank(){}

}
