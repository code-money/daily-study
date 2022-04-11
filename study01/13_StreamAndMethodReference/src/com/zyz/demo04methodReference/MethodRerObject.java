package com.zyz.demo04methodReference;

public class MethodRerObject {
    public static void printString(Printable p){
        p.print("Hello world");
    }

    public static void main(String[] args) {
        int a=1;
        printString((p)-> {
            System.out.println(p);
        });

//        printString(new PrintableImpl());
    }
}
