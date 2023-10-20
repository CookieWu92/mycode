package com.cookie.mycode.utils.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Desc: 文件（夹）夹编辑相关
 * @Author: CookieWu
 * @Date: 2023/10/20 15:10
 * @Version: v1.0
 */
public class FileEditer {

    /**
     * 复制文件夹：使用 commons-io包的工具类
     * @param srcDir
     * @param desDir
     * @throws IOException
     */
    public static void copyDirUtil(File srcDir, File desDir) throws IOException {
        FileUtils.copyDirectory(srcDir, desDir); //底层也用的递归
    }

    /**
     * 复制文件夹：自己递归实现
     * @param srcDir
     * @param desDir
     * @throws IOException
     */
    public static void copyDir(File srcDir, File desDir) throws IOException {
        final String canonicalPath = srcDir.getCanonicalPath();
        if (canonicalPath.equals(desDir.getCanonicalPath())) {
            throw new IllegalArgumentException(String
                    .format("源文件和目标文件不能相同: (srcDir='%s', desDir='%s')", srcDir, desDir));
        }
        if (!desDir.exists()) {
            desDir.mkdir();
        }
        File newDir = new File(desDir, srcDir.getName());
        newDir.mkdir();

        File[] files = srcDir.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                copyDir(file, newDir);
            } else {
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(newDir, file.getName()));
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
                fis.close();
                fos.close();
            }
        }
    }




}
