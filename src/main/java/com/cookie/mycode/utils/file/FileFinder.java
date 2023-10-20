package com.cookie.mycode.utils.file;

import org.fusesource.jansi.Ansi;
import static org.fusesource.jansi.Ansi.Color.*;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: 文件（夹）查找相关
 * @Author: CookieWu
 * @Date: 2023/10/20 9:57
 * @Version: v1.0
 */
public class FileFinder {

    /**
     * 在指定目录中查找名字包含关键字的文件
     * @param folder 源文件夹
     * @param keyword 关键字，注意区分大小写
     * @return
     */
    public static List<File> searchFiles(File folder, String keyword) {
        List<File> result = new ArrayList<>();
        if (folder.isFile())
            result.add(folder);

        File[] subFolders = folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                }
                if (file.getName().contains(keyword)) {
                    return true;
                }
                return false;
            }
        });

        if (subFolders != null) {
            for (File file : subFolders) {
                if (file.isFile()) {
                    // 如果是文件则将文件添加到结果列表中
                    result.add(file);
                } else {
                    // 如果是文件夹，则递归调用本方法，然后把所有的文件加到结果列表中
                    result.addAll(searchFiles(file, keyword));
                }
            }
        }
        return result;
    }

    /**
     * 在指定目录中查找名字包含指定后缀名的文件
     * @param folder 源文件夹
     * @param keyword 后缀名，注意区分大小写
     * @return
     */
    public static List<File> searchSuffixFiles(File folder, String keyword) {
        List<File> result = new ArrayList<>();
        if (folder.isFile())
            result.add(folder);

        File[] subFolders = folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                }
                if (file.getName().endsWith(keyword)) {
                    return true;
                }
                return false;
            }
        });

        if (subFolders != null) {
            for (File file : subFolders) {
                if (file.isFile()) {
                    // 如果是文件则将文件添加到结果列表中
                    result.add(file);
                } else {
                    // 如果是文件夹，则递归调用本方法，然后把所有的文件加到结果列表中
                    result.addAll(searchFiles(file, keyword));
                }
            }
        }
        return result;
    }

    /**
     * 以类图形化的形式，展开显示文件夹结构
     * @param folder 源文件夹
     * @param count 换行展示时需要空出的tab位个数
     */
    public static void showDir(File folder,int count) {
        String dirTree = "|-" + folder.getName();
        System.out.println(Ansi.ansi().fg(YELLOW).a(dirTree).reset());
        File[] files = folder.listFiles();
        count++;
        for (File file : files) {
            System.out.print(printTab(count));
            if (file.isFile()) {
                String fileTree = "|-" + file.getName();
                System.out.println(Ansi.ansi().fg(GREEN).a(fileTree).reset());
            } else {
                showDir(file,count);
            }
        }
    }

    private static String printTab(int count){
        String str = "";
        for (int i = 0; i < count; i++) {
            str += " ";
        }
        return str;
    }

}
