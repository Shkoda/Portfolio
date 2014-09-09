package com.pelican.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by Nightingale on 20.08.2014.
 */
public class MD5 {

    public static String getHash(String pass) {
        String hash = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
             //Get the hash's bytes
            byte[] bytes = md.digest(pass.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            hash = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hash;
    }

    public static void main(String[] args) {
        String testPass = "123";
        System.out.println(testPass+"\n"+getHash(testPass));

        String testPass2 = "qwerty";
        System.out.println(testPass2+"\n"+getHash(testPass2));
    }
}
