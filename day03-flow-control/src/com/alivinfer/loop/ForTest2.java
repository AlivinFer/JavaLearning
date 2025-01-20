package com.alivinfer.loop;

/**
 * @author Fer
 * @version 1.0
 * @description for 循环累加使用
 * @date 2025/1/20
 */

public class ForTest2 {
    public static void main(String[] args) {
        // 目标：完成for循环求和的案例。
        System.out.println("1到100的和是：" + sum(100));
    }

    public static int sum(int n){
        // 1、初始化一个变量：首先，你需要一个变量来存储累加和，初始值设为0。
        int sum = 0;
        // 2、循环结构
        for (int i = 1; i <= n; i++) {
            // 3、累加操作：在每次循环中，将当前数字加到累加变量上
            sum += i;
        }
        // 4、返回结果
        return sum;
    }
}
