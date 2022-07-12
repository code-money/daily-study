package cn.zyz.sggbase3.java;


/**
 * 演示线程死锁的问题
 */
public class DeadLockTest {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(()->{
           synchronized (s1){
               s1.append("a");
               s2.append(1);
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized (s2){
                   s1.append("b");
                   s2.append("2");
               }
           }
        }).start();

        new Thread(()->{
            synchronized (s2){
                s1.append("c");
                s2.append(4);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (s1){
                    s1.append("d");
                    s2.append(4);
                    System.out.println(s1);
                    System.out.println(s2);
                }
            }
        }).start();


    }
}
