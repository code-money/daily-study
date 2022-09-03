package cn.zyz.juc.volatiles;

import java.util.concurrent.TimeUnit;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-09-02 17:12
 **/


class MyNumber {
    int number;

    public void increment() {
        number+=1;
    }
}

public class VolatileNotAtomicDemo {
    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myNumber.increment();
                }
            }, "线程" + i).start();
        }
        try { TimeUnit.SECONDS.sleep(2 );}catch (Exception e){e.printStackTrace();}

        //System.out.println(myNumber.number);

        System.out.println(Thread.currentThread().getThreadGroup());
    }
}



