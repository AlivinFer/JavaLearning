package com.alivinfer.demoInputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Fer
 * @version 1.0
 * @description 读取多个字节
 * @date 2025/2/9
 */

public class FileInputStreamDemo1 {
    public static void main(String[] args) {
        try (InputStream fis = new FileInputStream("day11-file-io\\resource\\test.txt")) {
            byte[] buffer = new byte[3];
            // 定义一个变量记住每次读取了多少个字节。
            int len;
            while ((len = fis.read(buffer)) != -1) {
                // 把读取到的字节数组转换成字符串输出
                String str = new String(buffer,0, len);
                // 每次读取多个字节，性能得到提升，因为每次读取多个字节，可以减少硬盘和内存的交互次数，从而提升性能
                // 依然无法避免读取汉字输出乱码的问题：存在截断汉字字节的可能性！
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
