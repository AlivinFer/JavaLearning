package com.alivinfer.demoOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Fer
 * @version 1.0
 * @description 输出文件（字节流）
 * @date 2025/2/9
 */

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        // 追加数据
        try (OutputStream fos = new FileOutputStream("day11-file-io\\resource\\outputTest.txt", true)) {

            fos.write(97);
            fos.write('c');

            // 写入一个字符数据 会乱码
            // os.write('天');
            // 换行
            fos.write("\r\n".getBytes());

            // 3、写一个字节数组出去
            // public void write(byte[] b)
            byte[] bytes = "庆历二年春".getBytes();
            fos.write(bytes);
            // 换行
            fos.write("\r\n".getBytes());

            // 4、写一个字节数组的一部分出去
            // public void write(byte[] b, int pos, int len)
            fos.write(bytes, 0, 3);
            // 换行
            fos.write("\r\n".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
