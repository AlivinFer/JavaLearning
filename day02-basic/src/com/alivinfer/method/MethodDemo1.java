package com.alivinfer.method;

/**
 * @author Fer
 * @version 1.0
 * @description 方法重载
 * @date 2025/1/18
 */

public class MethodDemo1 {
    public static void main(String[] args) {
        print(10);
        print("hello");
        print(10.0, 20);
        print(20, 10.0);

        fire(10, 20);
        fire(10.0, 20.0, "1000");
    }

    // 定义一个方法，打印一个整数
    public static void print(int a) {
        System.out.println(a);
    }

    // 定义一个重载的方法
    public static void print(String str) {
        System.out.println(str);
    }

    // 定义一个重载的方法
    public static void print(double d, int a) {
        System.out.println("a:" + a + " d:" + d);
    }

    public static void print(int a, double d) {
        System.out.println(d);
    }

    // 重复的方法，冲突了！
//    public static void print(int a1, double d1) {
//        System.out.println(d1);
//    }

    // 注意：方法重载只关心方法名称相同，形参列表不同（类型不同，个数不同, 顺序不同），其他都无所谓、

    // 需求：发射导弹
    public static void fire(int x, int y) {
        System.out.println("发射导弹，坐标：" + x + "," + y);
    }

    // 定义一个重载方法
    public static void fire(double x, double y, String location) {
        System.out.println("发射导弹，坐标：" + x + "," + y);
    }
}
