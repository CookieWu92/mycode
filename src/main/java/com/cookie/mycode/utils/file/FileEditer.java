package com.cookie.mycode.utils.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        ifSameCheck(srcDir, desDir);
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

    /**
     * 剪切文件夹：自己递归实现
     * @param srcDir
     * @param desDir
     * @throws IOException
     */
    public static void cutDir(File srcDir, File desDir) throws IOException {
        ifSameCheck(srcDir, desDir);
        if (!desDir.exists()) {
            desDir.mkdir();//删除源文件夹
        }
        File newDir = new File(desDir, srcDir.getName());
        newDir.mkdir();

        File[] files = srcDir.listFiles();
        if (files == null || files.length == 0) {
            srcDir.delete();
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                cutDir(file, newDir);
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
                //读写完后，删除源文件
                file.delete();
            }
        }
        srcDir.delete();
    }

    /**
     *  删除文件夹：自己递归实现
     * @param srcDir
     * @return
     */
    public static boolean deleteDir(File srcDir) {
        File[] files = srcDir.listFiles();
        if (files == null || files.length == 0) {
            return srcDir.delete();
        }

        for (File file : files) {
            if (file.isDirectory()) {
                deleteDir(file);
            } else {
                file.delete();
            }
        }
        return srcDir.delete();
    }

    /**
     * 复制指定类型文件
     * @param srcDir 源文件夹
     * @param desDir 目标文件夹
     * @param desFileSuffix 文件后缀名，注意区分大小写
     * @throws IOException
     */
    public static void copyTypeDir(File srcDir, File desDir, String desFileSuffix) throws IOException {
        isFolderCheck(srcDir);
        isFolderCheck(desDir);
        Map<File, String> map = serchTypeFile(srcDir, desFileSuffix);
        Set<Map.Entry<File, String>> entries = map.entrySet();
        for (Map.Entry<File, String> entry : entries) {
            File key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "---" + value);

            //给文件加上时间戳，防止文件重名.
            //这里有点问题，时间戳到毫秒值，如果电脑够快,可能两个同名文件加的时间戳一样，会造成文件的覆盖，唉~~
            String[] names = key.getName().split("\\."); //正则表达式的关系
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
            String format = sdf.format(new Date());
            String s = names[0] + "(" + format + ")." + names[1];

            File file = new File(desDir, s);
            FileUtils.copyFile(key,file);

        }
    }

    /**
     * 将符合条件的 文件路径-文件名 存到map集合中
     * @param srcDir 源文件夹
     * @param desFileSuffix 文件后缀名，注意区分大小写
     * @return
     */
    public static Map<File, String> serchTypeFile(File srcDir, String desFileSuffix){
        isFolderCheck(srcDir);
        Map<File, String> map = new HashMap<>();
        File[] files = srcDir.listFiles();
        if (files == null) {
            return map;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                map.putAll(serchTypeFile(file, desFileSuffix));
            } else {
                if (file.getName().endsWith(desFileSuffix)) {
                    map.put(file.getAbsoluteFile(), file.getName());
                }
            }
        }
        return map;
    }

    private static void ifSameCheck(File srcDir, File desDir) throws IOException {
        final String canonicalPath = srcDir.getCanonicalPath();
        if (canonicalPath.equals(desDir.getCanonicalPath())) {
            throw new IllegalArgumentException(String
                    .format("源文件和目标文件不能相同: (srcDir='%s', desDir='%s')", srcDir, desDir));
        }
    }

    private static void isFolderCheck(File file){
        if (!file.isDirectory()){
            throw new IllegalArgumentException(String
                    .format(file.getName() + "不是文件夹"));
        }
    }

}
