package com.zyz.mybatis.sqlsession.proxy;

import com.zyz.mybatis.cfg.Mapper;
import com.zyz.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-15 11:29
 **/

public class MapperProxy implements InvocationHandler {
    //map的key是全限定类名加方法名
    private Map<String,Mapper> mappers;
    private Connection connection;

    public MapperProxy(Map<String, Mapper> mappers,Connection connection) {
        this.mappers = mappers;
        this.connection = connection;
    }

    /**
     * 用于对方法进行增强,其实就是调用  selectList方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.获取方法名
        String methodName = method.getName();
        //2.获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        //3.组合key
        String key = className +"."+methodName;
        //4.获取mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
        //5.判断是否有mapper
        if (mapper==null){
            throw new IllegalAccessException("传入参数有误");
        }
        //6.调用工具类
        return new Executor().selectList(mapper,connection);
    }
}



