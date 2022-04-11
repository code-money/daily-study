package com.zyz.reflectdemo;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        Properties pro = new Properties();
        //通过反射获得ReflectTest的类加载器
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        //调用类加载器对象的方法获取输入流传入properties文件
        InputStream properties = classLoader.getResourceAsStream("pro.properties");
        //加载配置文件
        pro.load(properties);

        //2.获得文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //3.加载该类进内存
        Class<?> cls = Class.forName(className);

        //4.创建对象
        Object obj = cls.newInstance();
        Method declaredMethod = cls.getDeclaredMethod(methodName);
        declaredMethod.invoke(obj);
    }
}
