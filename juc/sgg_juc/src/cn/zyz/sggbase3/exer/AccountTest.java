package cn.zyz.sggbase3.exer;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account{
    private double money;
    ReentrantLock lock = new ReentrantLock();
    public void deposit(){

        synchronized (this) {
            for (int i = 0; i < 3; i++) {
                money+=1000;
                System.out.println(Thread.currentThread().getName()+"存钱,余额"+money);
            }
        }
    }
}



public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
        new Thread(()->{
            account.deposit();
        },"甲").start();
        new Thread(()->{
            account.deposit();
        },"乙").start();
    }
}
