package com.neusoft.springbootsell.utils;

import java.util.Random;

public class KeyUtil {
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number =  random.nextInt(100000)+ 999999;
        return System.currentTimeMillis() + String.valueOf(number);
    }

}