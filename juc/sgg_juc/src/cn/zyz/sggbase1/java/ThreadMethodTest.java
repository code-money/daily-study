package cn.zyz.sggbase1.java;


/*
    1.start():启动当前线程，调用run()方法
    2.yield():释放当前线程在cpu的执行权
    3.join():在线程a中调用线程b的join()方法，a进入阻塞状态，直到线程b执行完之后线程a才会结束阻塞态
    4.stop():已过时，结束当前线程的生命周期
    5.sleep(long milliseconds):让当前线程睡眠指定的毫秒数，等待的时间内是阻塞态
                               时间到了之后等待cpu分配资源，无需手动唤醒

    线程优先级:
    public final static int MIN_PRIORITY = 1;   最低级，在cpu中被分配资源的可能性较低
    public final static int NORM_PRIORITY = 5;  默认优先级
    public final static int MAX_PRIORITY = 10;  最高级，在cpu中被分配资源的可能性较高

 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread thread1 = new HelloThread("线程1");
        thread1.start();
        //显示主线程的优先级
        System.out.println("主线程:"+Thread.currentThread().getPriority());
        //显示thread1的优先级
        System.out.println(thread1.getName()+":"+thread1.getPriority());
        Thread.currentThread().setName("主线程");//给主线程设置name
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if (i == 20) {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class HelloThread extends Thread {

    public HelloThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if (i == 10) {
                yield();
            }
        }
    }
}
