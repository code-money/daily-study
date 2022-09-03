package cn.zyz.juc.aboutLocks;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-08-29 17:28
 **/


/**
 * 锁到底锁什么
 */
public class LockSyncDemo {
    private Object object = new Object();

    public void m1(){
        synchronized (object){
            System.out.println("-----hello synchronized code lock");
        }
    }

    public synchronized void m2(){
        System.out.println("-----hello synchronized code lock");
    }

    public static synchronized void m3(){
        System.out.println("-----hello synchronized code lock");
    }

    public static void main(String[] args) {

    }
}



