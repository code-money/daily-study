package cn.zyz.sggbase4.java;

/**
 * 生产者消费者问题
 * @program: juc
 * @author: zyz
 * @create: 2022-07-12 09:41
 **/

//店员
class Clerk{
    //产品数量0
    private int productCount=0;

    //生产者生产产品
    public synchronized void producerProduct() {
        if (productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+":开始生产第"+productCount+"个产品");
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //消费者消费产品
    public synchronized void consumerProduct() {
        if (productCount>0){
            System.out.println(Thread.currentThread().getName()+":开始消费第"+productCount+"个产品");
            productCount--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


//生产者
class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始生产产品……");
        while (true){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.producerProduct();
        }
    }
}


//消费者
class Consumer extends Thread{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName()+":开始消费产品……");
        while (true){
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumerProduct();
        }
    }
}




public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");
        p1.start();

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者1");
        c1.start();

        Consumer c2 = new Consumer(clerk);
        c2.setName("消费者2");
        c2.start();

    }
}



