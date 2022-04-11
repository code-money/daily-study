package com.zyz.demo05Consumer;

import java.util.function.Consumer;

public class Tes implements Consumer<String> {

    @Override
    public void accept(String name) {
        System.out.println(name);
        String reName = new StringBuffer((String) name).reverse().toString();
        System.out.println(reName);
    }
}
