package com.zyz.invoke.jdk_proxy;

public class AnimalDaoImpl implements AnimalDao{
    @Override
    public void eat(String food) {
        System.out.println("动物吃"+food);
    }
}
