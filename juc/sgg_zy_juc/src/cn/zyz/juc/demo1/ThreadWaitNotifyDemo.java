package cn.zyz.juc.demo1;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-07-12 18:19
 * 题目：现在两个线程，可以操作初始值为0的一个变量
 * 实现一个线程对该变量加1，一个线程对该变量减一
 * 实现交替，来10轮，变量初始值为0
 * 1    高聚合前提下，线程操作资源类
 * 2    判断/干活/通知
 * 3    多线程交互中，必须要防止多线程的"虚假唤醒"(判断只用while，不能用if，如果使用if可能造成虚假唤醒)
 **/
class AirConditioner {
    private int number = 0;

    public synchronized void increment() {
        /*
            使用if判断可能造成虚假唤醒
            例如：
                当上一次生产者1执行到if判断条件进入wait后，在下一次被唤醒的话会直接从wait后开始执行，即不进行if判断，所以会造成数据错误的问题。
                使用while循可以解决此问题，在下一此次被唤醒后，因为wait是在循环体中，即便从wait开始执行也会再次进行判断，判断后如果条件不成立
                该线程会继续wait，所以while循环可以解决虚假唤醒的问题
         */
//        if (number != 0) {
        while (number != 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println(Thread.currentThread().getName() + ":" + number);
        notifyAll();
    }

    public synchronized void decrement() {
        /*
            使用if判断可能造成虚假唤醒
            例如：
                上边increment()方法已经说了造成虚假唤醒的原因，不再赘述，此处要说一点
                当某一个消费者线程进入wait状态，并且经历一次虚假唤醒后，那么此时可能会出现一个消费者线程连续消费的情况。
                原因是，比如说消费者1进行一次虚假唤醒后此时number=-1，那么之后消费者1获取锁后都再进行if(number==0)
                就不会再进入wait状态了，所以可能出现消费者1一直进行消费的情况。
         */
//        if (number == 0) {
        while (number == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println(Thread.currentThread().getName() + ":" + number);
        notifyAll();
    }
}


public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        AirConditioner air = new AirConditioner();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                air.increment();
            }
        }, "生产者1").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                air.decrement();
            }
        }, "消费者1").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                air.increment();
            }
        }, "生产者2").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                air.decrement();
            }
        }, "消费者2").start();
    }
}



