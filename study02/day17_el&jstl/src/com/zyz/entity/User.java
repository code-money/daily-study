package com.zyz.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: study02
 * @author: zyz
 * @create: 2022-05-06 10:08
 **/

public class User {
    private String name;
    private Integer age;
    private Date birthday;

    public User(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public User() {
    }

    //格式化日期对象
    public String getBirStr(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(this.getBirthday());
        return format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}



