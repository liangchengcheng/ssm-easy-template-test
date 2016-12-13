package com.lcc.utils;

import java.util.Random;

/**
 * Created by lcc on 2016/12/13.
 */
public class RandomUtils {

    /**
     * 获取指定位数的的string随机数，随机范围为a-z A-Z 0-9
     * @param length string的长度
     * @return 指定length长度的随机字符串
     */
    public static String randomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(62);
            buf.append(str.charAt(num));
        }
        return buf.toString();
    }

    /**
     * 默认返回长度为5的随机字符串
     */
    public static String randomString(){
        return randomString(5);
    }
}
