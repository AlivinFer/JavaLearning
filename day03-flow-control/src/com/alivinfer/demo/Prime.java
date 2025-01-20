package com.alivinfer.demo;

/**
 * @author Fer
 * @version 1.0
 * @description 判断素数
 * @date 2025/1/20
 */

public class Prime {
    public static void main(String[] args) {
        int count = 0;
        // 1、遍历3-200
        for (int i = 3; i <= 200; i++) {
            // i = 101 102 103 103 ... 200
            // 2、每遍历到一个数字，判断这个数字是否是素数，是则输出。（独立功能独立成方法）
            if (isPrime(i)) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("素数的个数为：" + count);
    }

    public static boolean isPrime(int num) {
        // num = 101
        // 遍历到该数的平方根。因为如果n有一个因子大于它的平方根，那么它必定还有一个小于或等于它的平方根的因子
        // 如果都没有找到，那么num就是素数
        for (int i = 2; i <= Math.sqrt(num); i++) {
            // i = 2 3 4 5 ...
            // 2、判断num是否能被i整除，能则返回false，不能则返回true
            if (num % i == 0) {
                return false;
            }
        }
        // 是素数
        return true;
    }
}
