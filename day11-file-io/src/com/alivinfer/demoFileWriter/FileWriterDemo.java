package com.alivinfer.demoFileWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Fer
 * @version 1.0
 * @description 写入文件（字符流）
 * @date 2025/2/9
 */

public class FileWriterDemo {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("day11-file-io\\resource\\output.txt")) {
            fw.write("Hello, Java IO!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
