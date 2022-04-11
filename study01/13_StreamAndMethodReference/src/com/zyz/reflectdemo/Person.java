package com.zyz.reflectdemo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int age;
    private String name;
    private String gender;

    public void eat(){
        System.out.println("人吃饭");
    }
}
