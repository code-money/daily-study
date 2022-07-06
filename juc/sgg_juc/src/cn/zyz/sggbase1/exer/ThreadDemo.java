package cn.zyz.sggbase1.exer;


//练习，创建两个线程，一个遍历100内偶数，一个遍历100内奇数
public class ThreadDemo {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i%2==0){
                        System.out.println(Thread.currentThread().getName()+"::"+i);
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i%2!=0){
                        System.out.println(Thread.currentThread().getName()+"::"+i);
                    }
                }
            }
        }.start();
    }
}
