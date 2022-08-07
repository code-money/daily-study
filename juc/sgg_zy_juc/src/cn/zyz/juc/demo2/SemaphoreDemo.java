package cn.zyz.juc.demo2;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-07-15 09:45
 **/

/**
 *  信号灯
 *  在信号量上我们定义两种操作：
 *   acquire（获取） 当一个线程调用acquire操作时，它要么通过成功获取信号量（信号量减1），
 *         要么一直等下去，直到有线程释放信号量，或超时。
 *   release（释放）实际上会将信号量的值加1，然后唤醒等待的线程。
 *
 *   信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制。
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t抢占到了车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },"线程"+i).start();
        }
    }
}

//当new Semaphore(1) 也就是信号量为1时，上面程序等于以下代码:
//class Place{  //车位
//    synchronized void getPlace()  {
//        System.out.println(Thread.currentThread().getName()+"\t抢到了车位");
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName()+"\t离开了车位");
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Place place = new Place();
//        for (int i = 0; i < 6; i++) {
//            new Thread(()->{place.getPlace();},"线程"+i).start();
//        }
//    }
//}



