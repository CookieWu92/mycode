package com.cookie.mycode.utils.file;

import org.junit.Test;

import java.io.File;

/**
 * @Desc:
 * @Author: CookieWu
 * @Date: 2023/10/20 14:49
 * @Version: v1.0
 */
public class FileCalculaterTest {
    @Test
    public void calculateSize(){
        long size1 = FileCalculater.calculateSize(new File(FileConstant.filePath1));
        long size2 = FileCalculater.calculateSize(new File(FileConstant.filePath2));
        System.out.println(size1);
        System.out.println(size2);
    }

}
