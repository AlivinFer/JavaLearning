package com.alivinfer.array;

/**
 * @author Fer
 * @version 1.0
 * @description 数组初体验
 * @date 2025/1/20
 */

public class ArrayDemo {
    public static void main(String[] args) {
        // 一维数组
        int[] oneDimArray = {10, 20, 30, 40, 50};
        System.out.println("一维数组的长度：" + oneDimArray.length);
        System.out.println("一维数组的元素：");
        for (int i = 0; i < oneDimArray.length; i++) {
            System.out.println("Index " + i + ": " + oneDimArray[i]);
        }

        // 使用增强型 for 循环
        System.out.println("使用增强型 for 遍历一维数组：");
        for (int num : oneDimArray) {
            System.out.println(num);
        }

        // 二维数组
        int[][] twoDimArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("二维数组的行数：" + twoDimArray.length);
        System.out.println("第1行的列数：" + twoDimArray[0].length);
        System.out.println("二维数组的元素：");
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                System.out.print(twoDimArray[i][j] + " ");
            }
            System.out.println();
        }

        // 使用增强型 for 遍历二维数组
        System.out.println("使用增强型 for 遍历二维数组：");
        for (int[] row : twoDimArray) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
