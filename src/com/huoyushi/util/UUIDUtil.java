package com.huoyushi.util;

import java.util.UUID;

public class UUIDUtil {

    public static  String generateuuid() {
       return UUID.randomUUID().toString();
    }
}