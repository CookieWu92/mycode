package com.cookie.mycode.utils.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Desc:
 * @Author: CookieWu
 * @Date: 2023/10/20 15:10
 * @Version: v1.0
 */
public class FileEditerTest {

    @Test
    public void copyDirUtil() throws IOException {
        String srcPath = FileConstant.folderPath1;
        String dirPath = "D:\\测试";
//        FileEditer.copyDirUtil(new File(srcPath), new File(dirPath));
        FileEditer.copyDir(new File(srcPath), new File(dirPath));
    }

}
