package com.pelican;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Nightingale on 09.09.2014.
 */
public class GenerateHashTest {
//    public static void main(String[] args) {
//        System.out.println(MD5.getHash("admin"));
//        System.out.println(MD5.getHash("123"));
//    }

    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("admin"));
        System.out.println(encoder.encode("123"));
    }
}
