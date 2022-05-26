package cglib;

/**
 * @program: day01_eesy_03spring
 * @author: zyz
 * @create: 2022-05-23 11:37
 **/


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 模拟一个消费者
 */
public class Client {
    public static void main(String[] args) {
        ProducerDao producer = new ProducerDao();
        ProducerDao producerDao = (ProducerDao)Enhancer.create(producer.getClass(), (MethodInterceptor)
                (obj, method, parameters, proxy) -> {
                    float money = (float) parameters[0];
                    System.out.println("执行前");
                    Object invoke = method.invoke(producer, money + 100f);
                    System.out.println("执行后");
                    return invoke;
                });
        producerDao.saleProduct(500f);
    }
}



