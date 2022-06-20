package com.zyz.entity;

public class Person {
    private Integer age;
    private String name;

    public Person() {
        this.name="张三";
        this.age=13;
    }


    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
