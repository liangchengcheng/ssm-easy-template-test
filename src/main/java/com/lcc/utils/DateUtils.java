package com.lcc.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lcc on 2016/12/13.
 */
public class DateUtils {

    public static String getCurrentTimeFormatedString(String template){
        Date date = new Date();
        return formate(date,template);
    }

    public static String getCurrentTimeFormatedString(){
        return getCurrentTimeFormatedString("yyyy-MM-dd-HH-mm-ss");
    }

    public static String formate(Date date,String template){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(template);
        return  simpleDateFormat.format(date);
    }

}
