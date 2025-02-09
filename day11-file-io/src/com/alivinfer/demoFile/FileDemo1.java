package com.alivinfer.demoFile;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author Fer
 * @version 1.0
 * @description File 遍历使用方法
 * @date 2025/2/8
 */

public class FileDemo1 {
    public static void main(String[] args) {
        // 指定要遍历的目录
        File dir = new File("C:\\Users\\Public");

        // 获取文件和目录名
        String[] strFiles = dir.list();
        if (strFiles != null) {
            for (String file : strFiles) {
                System.out.println(file);
            }
        } else {
            System.out.println("目录不存在或无法访问");
        }

        // 获取 `File` 数组
        File[] listFiles = dir.listFiles();

        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    System.out.println("[文件] " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("[目录] " + file.getName());
                }
            }
        } else {
            System.out.println("目录不存在或无法访问");
        }

        // 仅列出 .txt 文件
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt"); // 只返回 .txt 文件
            }
        });

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("目录不存在或无匹配文件");
        }

        // 调用递归方法
        listAllFiles(dir);
    }

    public static void listAllFiles(File dir) {
        if (dir.exists() && dir.isDirectory()) {
            // 获取当前目录下的所有文件和子目录
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        System.out.println("[目录] " + file.getAbsolutePath());
                        // 递归遍历子目录
                        listAllFiles(file);
                    } else {
                        System.out.println("[文件] " + file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("目录不存在或无法访问");
        }
    }
}
