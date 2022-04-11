package com.zyz.demo04Supplier;

import java.util.function.Supplier;

public class Demo01Supplier {
    public static String getStr(Supplier<String> supplier){
        return supplier.get();
    }

    public static void main(String[] args) {
        String str=getStr( () -> "琅琊榜");
        System.out.println(str);
    }

}
