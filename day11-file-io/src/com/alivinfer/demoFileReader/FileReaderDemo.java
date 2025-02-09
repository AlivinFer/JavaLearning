package com.alivinfer.demoFileReader;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author Fer
 * @version 1.0
 * @description 读取文件（字符流）
 * @date 2025/2/9
 */

public class FileReaderDemo {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("day11-file-io\\resource\\test.txt")) {
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
