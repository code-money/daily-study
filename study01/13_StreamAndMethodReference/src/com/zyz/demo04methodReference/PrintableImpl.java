package com.zyz.demo04methodReference;

public class PrintableImpl implements Printable{
    public PrintableImpl() {
    }

    @Override
    public void print(String str) {
        System.out.println(str);
    }
}
