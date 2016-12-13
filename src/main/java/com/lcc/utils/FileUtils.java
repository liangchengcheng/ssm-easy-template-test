package com.lcc.utils;

/**
 * Created by lcc on 2016/12/13.
 */
public class FileUtils {

    /**
     * 根据文件名称获取文件的类型
     */
    public static String getFileType(String fileName){
        int index = fileName.lastIndexOf(".");
        int length = fileName.length();
        String fileType = null;
        if (index == -1){
            fileType = "";
        }else {
            fileType = fileName.substring(index,length);
        }
        return fileType;
    }
}
