package com.alivinfer.type;

/**
 * @author Fer
 * @version 1.0
 * @description 自动类型转换
 * @date 2025/1/18
 */

public class TypeDemo1 {
    public static void main(String[] args) {
        byte a = 12;
        // 自动类型转换
        print(a);
        // 自动类型转换
        print2(a);

        System.out.println("=====================");

        int i = 20;
        // print3(i); // 类型范围大的变量不能直接赋值给类型范围小的变量，会报错的！！
        // 强制类型转换。 类型 变量2 = （类型）变量1;
        byte j = (byte) i;
        print3(j);

        System.out.println("=====================");

        int m = 1500;
        byte n = (byte) m;
        System.out.println(m);
        // 出现数据溢出！！
        System.out.println(n);

        System.out.println("=====================");

        double k = 3.14;
        // 浮点型转换成整数，直接去掉小数部分
        int l = (int) k;
        // 3
        System.out.println(l);
    }

    public static void print(int b) {
        System.out.println(b);
    }

    public static void print2(double c) {
        System.out.println(c);
    }

    public static void print3(byte j) {
        System.out.println(j);
    }
}
