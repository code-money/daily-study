package com.zyz.jedis;

import com.zyz.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-11 21:29
 **/

public class JedisTest {

    public static void main(String[] args) {

    }
    @Test
    public void test01(){
        //1.获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //2.操作
        jedis.set("username","zhangsan");
        jedis.close();
    }

    //string 数据结构操作
    @Test
    public void test02(){
        //1.获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //2.操作
        jedis.set("username","zhangsan");
        String username = jedis.get("username");
        System.out.println(username);

        //可以使用setex()方法存储可以指定过期的时间
        jedis.setex("activecode",10,"hehe");  //将activecode：hehe键值对存入redis，并且设置20s的过期时间
        jedis.close();
    }

    //hash 数据结构操作
    @Test
    public void test03(){
        //1.获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //2.操作
        jedis.hset("user","name","lisi");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","male");

        //获取
        String name = jedis.hget("user", "name");
        System.out.println(name);

        Map<String, String> users = jedis.hgetAll("user");
        Set<String> keys = users.keySet();
        for (String key : keys) {
            System.out.println(key+":"+users.get(key));
        }

        jedis.close();
    }

    //list 数据结构
    @Test
    public void test04(){
        //1.获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //2.操作
        //list的存储
        jedis.del("mylist");
        jedis.lpush("mylist","a","b","c");
        jedis.rpush("mylist","a","b","c");

        //获取所有
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        //list弹出
        String element1 = jedis.lpop("mylist");
        System.out.println(element1);

        String element2 = jedis.rpop("mylist");
        System.out.println(element2);
    }

    /*
        jedis连接池使用
     */
    @Test
    public void test05(){
        //0.创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);

        //1.创建jedis连接池对象
        JedisPool pool = new JedisPool();

        //2.获取连接
        Jedis resource = pool.getResource();

        //3.使用
        resource.set("hi","hello");

        //4.关闭，归还到连接池中
        resource.close();

    }

    //Jedis连接池工具类测试
    @Test
    public void test06(){
        Jedis jedis = JedisPoolUtils.getJedis();
        System.out.println(jedis);

    }

}



