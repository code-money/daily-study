package cn.zyz.sggbase5.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 *  实现CallAble接口创建线程
 *
 *  Callable接口比Runnable接口强在哪里？
 *  1.Callable接口call方法可以有返回值
 *  2.call方法可以抛出异常
 *  3.Callable支持泛型
 *
 * @program: juc
 * @author: zyz
 * @create: 2022-07-12 11:59
 **/
//1.创建一个实现Callable接口的实现类
class NumThread implements Callable{
    //2.实现Callable方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum =0;
        for (int i = 0; i <= 100; i++) {
            if (i%2==0){
                sum+=i;
            }
        }
        return sum;
    }
}


public class ThreadCallAble {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread thread = new NumThread();
        //4.将次Callable实现类对象传递到FutureTask构造器当中
        FutureTask futureTask = new FutureTask(thread);
        //5.将FutureTask对象作为参数传递到Thread类构造方法中
        new Thread(futureTask).start();
        try {
            //6.获取Callable实现类对象中call()方法的返回值
            //返回值是call()方法返回值
            Object sum = futureTask.get();
            System.out.println((int)sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}



