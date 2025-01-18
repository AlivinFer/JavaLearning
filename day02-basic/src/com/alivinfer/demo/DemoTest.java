package com.alivinfer.demo;

import java.util.Scanner;

/**
 * @author Fer
 * @version 1.0
 * @description BMI BMR
 * @date 2025/1/18
 */

public class DemoTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请您输入您的身高（米）：");
        double height = sc.nextDouble();
        System.out.println("您的身高是：" + height + "米");

        System.out.println("请您输入您的体重：");
        double weight = sc.nextDouble();
        System.out.println("您的体重是：" + weight + "千克");

        System.out.println("请您输入您的性别（男/女）：");
        String sex = sc.next();

        System.out.println("请您输入您的年龄：");
        int age = sc.nextInt();

        double bmi = calcBMI(height, weight);
        System.out.println("您的bmi值是：" + bmi);

        double bmr = calcBMR(height, weight, sex, age);
        System.out.println("您的bmr值是：" + bmr);
    }

    // 2、根据个人信息，计算BMI指数（把数据交给一个独立的方法来计算并返回这个结果）
    public static double calcBMI(double height, double weight) {
        return weight / (height * height);
    }

    // 3、根据个人信息，计算BMR指数（把数据交给一个独立的方法来计算并返回这个结果）
    public static double calcBMR(double height, double weight, String sex, int age) {
        double bmr = 0;
        if ("男".equals(sex)) {
            bmr = 88.362 + (13.397 * weight + 4.799 * height - 5.677 * age) ;
        } else {
            bmr = 447.593 + (9.247 * weight + 3.098 * height - 4.330 * age);
        }
        return bmr;
    }
}
