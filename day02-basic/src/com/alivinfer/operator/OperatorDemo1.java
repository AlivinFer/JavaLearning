package com.alivinfer.operator;

/**
 * @author Fer
 * @version 1.0
 * @description 自增自减运算符
 * @date 2025/1/18
 */

public class OperatorDemo1 {
    public static void main(String[] args) {
        print(10);
        System.out.println("=========================");
        print2(10);
    }

    // 设计一个方法，接收一个整数。
    public static void print(int a) {
        a++;
        ++a;
        System.out.println(a);

        a--;
        --a;
        System.out.println(a);
    }

    // 设计一个方法，理解自增和自减放在变量前后的区别
    public static void print2(int a) {
        // 先用后加
        int b = a++;
        // 11
        System.out.println(a);
        // 10
        System.out.println(b);

        // 先加后用
        int c = ++a;
        // 12
        System.out.println(a);
        // 12
        System.out.println(c);
    }
}
