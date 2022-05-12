package com.zyz.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zyz.entity.Person;
import org.junit.Test;

import java.io.File;
import java.util.*;
import java.util.stream.Stream;

/**
 * @program: study03
 * @author: zyz
 * @create: 2022-05-11 17:13
 **/

public class JacksonTest {

    //Java对象转为JSON字符串
    @Test
    public void test01() throws Exception {
        //1.创建Person对象
        Person p1=new Person("张三",23,"男",null);

        //2.创建Jackson核心对象
        ObjectMapper mapper = new ObjectMapper();

        //3.调用方法转换
        /*
            writeValue(参数1，obj):
                参数1：
                    File: 将obj对象转换为JSON字符串，并保存到指定的文件中
                    Writer: 将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
                    OutputStream: 将obj对象转换为JSON字符串，并将json数据填充到字节输出流中

            writeValueAsString(obj):将对象转换为json字符串
         */
//        System.out.println(mapper.writeValueAsString(p1));

        //输出到d盘下的a.txt文件
        mapper.writeValue(new File("d://a.txt"),p1);
    }

    @Test
    public void test02() throws Exception {
        //1.创建Person对象
        Person p1=new Person("张三",23,"男",new Date());


        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(p1));
    }

    @Test
    public void test03() throws Exception {
        //1.创建Person对象
        Person p1=new Person("张三",23,"男",new Date());
        Person p2=new Person("李四",23,"男",new Date());
        Person p3=new Person("王五",23,"男",new Date());

        List<Person> ps = new ArrayList<>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);



        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(ps));
    }

    @Test
    public void test04() throws Exception {

        Person p1=new Person("张三",23,"男",new Date());
        Person p2=new Person("李四",23,"男",new Date());
        Person p3=new Person("王五",23,"男",new Date());
        //1.创建Map对象
        Map<String,Object> map = new HashMap<>();
        map.put("p1",p1);
//        map.put("p2",p2);
//        map.put("p3",p3);


        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(map));
    }
}



