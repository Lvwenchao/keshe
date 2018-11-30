package com.lv.utils;


import java.util.UUID;

/**
 * @author: Mrlv
 * @data: 2018/11/17 12:42
 * @description: 生成激活码
 * @Version: 1.0
 **/
public class ActiveCodeUtils {
    public static String createActiveCode(){
        return UUID.randomUUID().toString();
    }
}
