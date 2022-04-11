package com.zyz.demo07SuperMethodReference;

public class Man extends Human{
    @Override
    public void sayHello() {
        System.out.println("Hello我是Man");
    }

    public static void method(Greetable g){
        g.greet();
    }

    public void show(){
//        method(()->{
//            Human human = new Human();
//            human.sayHello();
//        });

//        method(()->{
//            super.sayHello();
//        });

        method(super::sayHello);

    }
    public static void main(String[] args) {
        int a=0;
        new Man().show();
    }
}
