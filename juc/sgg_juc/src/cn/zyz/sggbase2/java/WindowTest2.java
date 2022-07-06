package cn.zyz.sggbase2.java;


class Window2 extends Thread {

    public Window2() {
    }

    public Window2(String name) {
        super(name);

    }

    //创建类变量来使得多个线程共享数据
    private static int ticket = 50;
    //创建一个Object类型的类变量，用来作为类锁
    private static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            //使用同步代码块包裹，对当前类进行上锁
//        synchronized (obj){
            //通过传递当前类的class对象也可以完成类锁
            synchronized (Window2.class) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + ticket--);
                }else {
                    break;
                }
            }
        }

    }
}

//实现类锁
public class WindowTest2 {
    public static void main(String[] args) {
        new Window2("窗口1").start();
        new Window2("窗口2").start();
        new Window2("窗口3").start();
    }
}

