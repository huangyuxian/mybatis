package edu.nf.ch04.utils;

import java.util.UUID;

public class UUIDUtil {

    public static String createUUID(){
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }
}
