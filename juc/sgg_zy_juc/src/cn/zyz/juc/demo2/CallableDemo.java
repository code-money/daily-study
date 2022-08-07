package cn.zyz.juc.demo2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @program: juc
 * @author: zyz
 * @create: 2022-07-14 18:44
 *
 * 实现Callable接口实现多线程
 **/
class MyThread1 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("-----CallAble接口");
        TimeUnit.SECONDS.sleep(4);
        return 1024;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread1 thread1 = new MyThread1();
        FutureTask<Integer> task = new FutureTask(thread1);
        new Thread(task).start();
        new Thread(task).start();
        System.out.println(Thread.currentThread().getName()+"----计算完成");
        System.out.println(task.get());
    }
}



