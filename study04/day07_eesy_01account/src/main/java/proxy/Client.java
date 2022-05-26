package proxy;

/**
 * @program: day01_eesy_03spring
 * @author: zyz
 * @create: 2022-05-23 11:37
 **/


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 */
public class Client {
    public static void main(String[] args) {
         ProducerDao producer = new ProducerDao();
        Producer pro = (Producer)Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                (proxy, method, parameters) -> {
                    float money = (float) parameters[0];
                    System.out.println("执行前");
                    Object invoke = method.invoke(producer, money+100f);
                    System.out.println("执行后");
                    return invoke;
                });

        pro.saleProduct(500f);
    }
}



