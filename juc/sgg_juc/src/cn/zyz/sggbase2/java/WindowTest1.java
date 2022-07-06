package cn.zyz.sggbase2.java;


class Window implements Runnable {

    private int ticket = 50;
    //创建一个Object类型的成员变量，用来作为对象锁
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            //使用synchronized包裹，对当前对象进行上锁
//        synchronized (obj){
            //传递this对象也可以完成对象锁
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }

    }
}


//实现对象锁
public class WindowTest1 {
    public static void main(String[] args) {
        Window ticket = new Window();
        new Thread(ticket, "窗口1").start();
        new Thread(ticket, "窗口2").start();
        new Thread(ticket, "窗口3").start();
    }
}
