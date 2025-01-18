package com.alivinfer.operator;

/**
 * @author Fer
 * @version 1.0
 * @description 基本算数运算符
 * @date 2025/1/18
 */

public class OperatorDemo {
    public static void main(String[] args) {
        // print(10, 2);
        print(10, 3);

        System.out.println("---------------------------------");

        print2();
    }

    public static void print(int a, int b) {
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        // 3.3333... ==> 3
        System.out.println(a / b);
        System.out.println((double) a / b);
        System.out.println(1.0 * a / b);
        System.out.println(a % b);
    }

    // 需求：研究+符号做连接符还是做运算符.
    public static void print2() {
        int a = 5;
        // abc5
        System.out.println("abc" + a);
        // 10
        System.out.println(a + 5);
        // fer5a
        System.out.println("fer" + a + 'a');
        // 5afer
        System.out.println(a + 'a' + "fer");
    }
}
