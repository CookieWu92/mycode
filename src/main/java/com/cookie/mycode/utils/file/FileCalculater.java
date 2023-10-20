package com.cookie.mycode.utils.file;

import java.io.File;

/**
 * @Desc: 文件（夹）计算相关
 * @Author: CookieWu
 * @Date: 2023/10/20 14:45
 * @Version: v1.0
 */
public class FileCalculater {

    /**
     * 计算文件/文件夹大小
     * @param srcDir
     * @return
     */
    public static long calculateSize(File srcDir) {
        long size = 0;
        if (srcDir.isFile()){
            return srcDir.length();
        }
        File[] files = srcDir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                size += calculateSize(file);
            } else {
                size += file.length();
            }
        }
        return size;
    }

}
