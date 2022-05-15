package com.zyz.mybatis.io;

import java.io.InputStream;

/**
 * @program: study04
 * @author: zyz
 * @create: 2022-05-15 10:45
 **/

public class Resources {
    public static InputStream getResourceAsStream(String filepath){
//        return Resources.class.getClassLoader().getResourceAsStream(filepath);
        InputStream asStream = Resources.class.getClassLoader().getResourceAsStream(filepath);
        return asStream;
    }
}



