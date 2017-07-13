package com.cheyitou.common.util;

import java.util.concurrent.ConcurrentHashMap;

public class CaptchaCache {

    private static ConcurrentHashMap<String, String> captchaMap = new ConcurrentHashMap<String, String>();

    public static String getValue(String mobile) {
        return captchaMap.get(mobile);
    }

    public static void setValue(String mobile, String code) {
        captchaMap.put(mobile, code);
    }

    public static void remove(String mobile) {
        captchaMap.remove(mobile);
    }

}
