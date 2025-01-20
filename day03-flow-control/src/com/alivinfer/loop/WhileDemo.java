package com.alivinfer.loop;

/**
 * @author Fer
 * @version 1.0
 * @description while 循环初体验
 * @date 2025/1/20
 */

public class WhileDemo {
    public static void main(String[] args) {
        // 目标：认识while循环的写法，搞清楚其执行流程。
        test1();
    }

    public static void test1() {
        int i = 0;
        while (i < 3) {
            System.out.println("Hello World!");
            i++;
        }
        // 3
        System.out.println(i);
    }
}
