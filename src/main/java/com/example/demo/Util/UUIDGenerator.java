package com.example.demo.Util;
import java.util.UUID;
/**
 * @description: 获取uuid
 */
public class UUIDGenerator {
    // 生成UUID
    public static String get(){
        String uuid =  UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }
}
