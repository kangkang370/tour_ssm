package com.xiaohan.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @description:
 * @author: 小韩同学
 * @date: 2020/10/13
 */
public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "admin";
        String pwd = encodePassword(password);
        System.out.println(pwd);
    }
}
