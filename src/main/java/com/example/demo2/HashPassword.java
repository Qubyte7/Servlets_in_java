package com.example.demo2;

import java.security.MessageDigest;

public class HashPassword {
    public static String dohashing(String passwords){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(passwords.getBytes());
            byte[] resultByteArray =  messageDigest.digest();
            StringBuilder resultString = new StringBuilder();
            for(byte b: resultByteArray){
                resultString.append(String.format("%02x",b));
            }
            return resultString.toString();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "";
    }
}
