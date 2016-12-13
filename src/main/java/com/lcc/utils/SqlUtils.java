package com.lcc.utils;

/**
 * Created by lcc on 2016/12/13.
 */
public class SqlUtils {

    /**
     * 转换javaboolean与mysql的int值
     */
    public static   boolean toBoolean(int intBoolean){
        return  intBoolean==1;
    }

    public  static int toInt(boolean booleanValue){
        return  booleanValue?1:0;
    }

}
