package cn.zyz.juc.demo2;

import java.util.concurrent.CountDownLatch;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-07-14 19:49
 **/

/**
 * 减少计数
 * CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，这些线程会阻塞。
 * 其他线程调用countDown()方法会将计数器减1(调用countDown方法的线程不会阻塞)，
 * 当计数器的值变为0时，因await()方法阻塞的线程会被唤醒，继续执行
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t离开教室");
                countDownLatch.countDown();
            },Integer.toString(i)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"\t班长关门走人");
    }
}



