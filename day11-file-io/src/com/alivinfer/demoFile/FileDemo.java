package com.alivinfer.demoFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Fer
 * @version 1.0
 * @description File 类操作示例
 * @date 2025/2/8
 */

public class FileDemo {
    public static void main(String[] args) {
        try {
            // 绝对路径：F:\code\Java\JavaLearning\day11-file-io\resource\example.txt
            // 相对路径
            File file = new File("day11-file-io\\resource\\example.txt");

            // 创建文件
            if (file.createNewFile()) {
                System.out.println("文件创建成功：" + file.getAbsoluteFile());
            } else {
                System.out.println("文件已存在");
            }

            // 获取文件信息
            System.out.println("文件名: " + file.getName());
            System.out.println("文件大小: " + file.length() + " 字节");
            System.out.println("是否可写: " + file.canWrite());
            System.out.println("是否可读: " + file.canRead());

            // delete方法默认只能删除文件和空文件夹，删除后的文件不会进入回收站
            if (file.delete()) {
                System.out.println("文件已删除");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}