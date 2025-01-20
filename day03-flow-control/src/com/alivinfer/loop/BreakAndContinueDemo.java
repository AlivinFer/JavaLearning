package com.alivinfer.loop;

/**
 * @author Fer
 * @version 1.0
 * @description break continue 使用初体验
 * @date 2025/1/20
 */

public class BreakAndContinueDemo {
    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                // 跳出并结束循环
                break;
            }
            System.out.println(i);
        }
    }

    public static void test2() {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                // 跳出本次循环，继续下一次循环
                continue;
            }
            System.out.println(i);
        }
    }
}
