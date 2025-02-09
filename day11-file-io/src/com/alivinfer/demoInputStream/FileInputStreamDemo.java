package com.alivinfer.demoInputStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Fer
 * @version 1.0
 * @description 读取文件（字节流）
 * @date 2025/2/9
 */

public class FileInputStreamDemo {
    public static void main(String[] args) {
        // try-with-resource 写法，该资源使用完毕后，会自动调用其close()方法，完成对资源的释放！
        try (FileInputStream fis = new FileInputStream("day11-file-io\\resource\\test.txt")) {
            int data;
            // 逐字节读取
            while ((data = fis.read()) != -1) {
                // 性能较差,读取汉字输出一定会乱码！
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
