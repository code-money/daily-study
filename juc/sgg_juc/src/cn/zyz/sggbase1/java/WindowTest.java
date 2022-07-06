package cn.zyz.sggbase1.java;



//卖票案例，声明Window(窗口)类实现Runnable接口
class Window implements Runnable {
    //窗口拥有100张票
    private int ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + ticket--);
        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window ticket = new Window();
        /*
            创建三个窗口也就是三个线程，线程对象都是使用相同的Window对象，所以都是对同一个Window对象中的票数操作
            三个窗口对同一个对象操作，所以三个窗口共享100张票
            一般在多线程环境下数据是共享的，所以使用实现Runnable接口的类要比继承Thread类的类更加方便应用
         */
        new Thread(ticket, "窗口1").start();
        new Thread(ticket, "窗口2").start();
        new Thread(ticket, "窗口3").start();
    }
}
