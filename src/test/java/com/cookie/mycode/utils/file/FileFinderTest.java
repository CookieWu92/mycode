package com.cookie.mycode.utils.file;

import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @Desc:
 * @Author: CookieWu
 * @Date: 2023/10/20 13:40
 * @Version: v1.0
 */
public class FileFinderTest {
    @Test
    public void searchFiles(){
        List<File> files = FileFinder.searchFiles(new File(FileConstant.folderPath1), "测试");
        System.out.println("共找到:" + files.size() + "个文件");
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }
    @Test
    public void searchSuffixFiles(){
        List<File> files = FileFinder.searchSuffixFiles(new File(FileConstant.folderPath1), ".txt");
        System.out.println("共找到:" + files.size() + "个文件");
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
    }

    @Test
    public void showDir(){
        FileFinder.showDir(new File(FileConstant.folderPath2), 1);
    }
}
