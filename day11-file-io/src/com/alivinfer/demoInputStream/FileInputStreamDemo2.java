package com.alivinfer.demoInputStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Fer
 * @version 1.0
 * @description 一次性读完文件的全部字节
 * @date 2025/2/9
 */

public class FileInputStreamDemo2 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("day11-file-io\\resource\\test.txt")) {
            byte[] bytes = fis.readAllBytes();

            String rs = new String(bytes);
            // 可以避免读取汉字输出乱码的问题
            System.out.println(rs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
