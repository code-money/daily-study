package cn.zyz.juc.atomics;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-09-05 13:51
 **/


class BankAccount{
    String bankNames ="CCB";

    //更新的对象属性必须使用 public volatile修饰
    public volatile int money=0;//钱数

    public  void add(){
        money++;
    }

    //因为对象的属性修改类型原子类都是抽象类，所以每次使用都必须
    //使用静态方法newUpdater()创建一个更新器，并且需要设置想要更新的类和属性
    AtomicIntegerFieldUpdater<BankAccount> fieldUpdater
            = AtomicIntegerFieldUpdater.newUpdater(BankAccount.class,"money");

    //不加synchronized，保证原子性
    public void transMoney(BankAccount bankAccount){
        fieldUpdater.getAndIncrement(bankAccount);
    }
}
public class AtomicIntegerFieldUpdaterDemo {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    //bankAccount.add();
                    bankAccount.transMoney(bankAccount);
                }
                countDownLatch.countDown();
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("结束："+bankAccount.money);
    }
}



