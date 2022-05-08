package com.zyz.web.jdk_proxy;




public class Demo {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDaoImpl();
        AnythingProxy proxy1 = new AnythingProxy(personDao);
        PersonDao instance1 = (PersonDao) proxy1.getInstance();
        instance1.method("小李");
        instance1.play("篮球");
        System.out.println("----------------------------------------------");
        AnimalDao animalDao = new AnimalDaoImpl();
        AnythingProxy proxy2 = new AnythingProxy(animalDao);
        AnimalDao instance2 = (AnimalDao) proxy2.getInstance();
        instance2.eat("饿了想吃肉");
    }
}
