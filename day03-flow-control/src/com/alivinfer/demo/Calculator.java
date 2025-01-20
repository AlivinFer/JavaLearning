package com.alivinfer.demo;

import java.util.Scanner;

/**
 * @author Fer
 * @version 1.0
 * @description 简易计算器实现
 * @date 2025/1/20
 */

public class Calculator {
    public static void main(String[] args) {
        // 目标：简易版计算器开发。
        // 1、键盘录入两个整数，以及运算符。
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字:");
        double num1 = sc.nextDouble();

        System.out.println("请输入第二个数字:");
        double num2 = sc.nextDouble();

        System.out.println("请输入运算符(+, -, *, /):");
        // "+"
        String operator = sc.next();

        // 2、把这个数据交给一个独立的计算方法，帮我计算结果并返回给我。
        double result = calc(num1, num2, operator);
        System.out.println("计算结果是：" + result);
    }

    public static double calc(double num1, double num2, String operator) {
        // 定义一个double类型的变量记录本次运算的结果，方便返回！！
        double result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                System.out.println("运算符有误，请重新输入");
        }
        return result;
    }
}
