package com.alivinfer.exception;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Fer
 * @version 1.0
 * @description 异常
 * @date 2025/1/23
 */

public class ExceptionDemo {
    public static void main(String[] args) {
        // show();
        try {
            // 监视代码，出现异常，会被catch拦截住这个异常
            show2();
        } catch (Exception e) {
            e.printStackTrace(); // 打印这个异常信息
        }
    }

    public static void show() {
        System.out.println("== 程序开始 ==");
        // 运行时异常的特点：编译阶段不报错，运行时出现的异常，继承自 RuntimeException。
        int[] arr = {1,2,3};
//         ArrayIndexOutOfBoundsException
//         System.out.println(arr[3]);

        // ArithmeticException
        // System.out.println(10/0);

        // 空指针异常
        String str = null;
        System.out.println(str);
        // NullPointerException
        System.out.println(str.length());

        System.out.println("== 程序结束 ==");
    }

    // 定义一个方法认识编译异常。
    public static void show2() throws Exception {
        System.out.println("== 程序开始 ==");
        // 编译异常：编译阶段报错，编译不通过。
        String str = "2025-01-23 15:23:13";
        // 把字符串时间解析成Java中的一个日期对象。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        // 编译时异常，提醒程序员这里的程序很容易出错，请您注意！
        Date date = sdf.parse(str);
        System.out.println(date);

        InputStream is = new FileInputStream("D:/meinv.png");

        System.out.println("== 程序结束 ==");
    }
}
