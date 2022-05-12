package com.zyz.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * @program: study03
 * @author: zyz
 * @create: 2022-05-11 17:12
 **/

public class Person {
    private String name;
    private Integer age;
    private String gender;
//    @JsonIgnore  //忽略该属性
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  //设置该属性的格式
    private Date birtyday;


    public Person() {
    }

    public Person(String name, Integer age, String gender,Date birtyday) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birtyday = birtyday;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirtyday() {
        return birtyday;
    }

    public void setBirtyday(Date birtyday) {
        this.birtyday = birtyday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", birtyday=" + birtyday +
                '}';
    }
}



