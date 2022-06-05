package cn.zyz.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @program: heima_ssm
 * @author: zyz
 * @create: 2022-06-02 17:39
 **/

public class BCryptPasswordEncoderUtils {
    public static String encode(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);
        return encode;
    }

    public static void main(String[] args) {
        String encode = encode("123456");
        System.out.println(encode);
    }
}



