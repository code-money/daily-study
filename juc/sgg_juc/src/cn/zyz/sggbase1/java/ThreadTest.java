package cn.zyz.sggbase1.java;


class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}


public class ThreadTest {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.run();
        thread.start();
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
