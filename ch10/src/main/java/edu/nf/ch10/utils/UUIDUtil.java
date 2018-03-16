package edu.nf.ch10.utils;

import java.util.UUID;

public class UUIDUtil {
    public static String createUUID(){
        String uuid  = UUID.randomUUID().toString();
        return uuid.replace("-","");
    }

    public static void main(String[] args) {
        System.out.println(createUUID());
    }
}
