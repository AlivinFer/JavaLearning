package com.alivinfer.object;

/**
 * @author Fer
 * @version 1.0
 * @description 测试学生类
 * @date 2025/1/20
 */

public class TestDemo1 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "播妞";
        s1.chinese = 100;
        s1.math = 100;
        s1.printAllScore();
        s1.printAverageScore();
        System.out.println(s1);


        Student s2 = new Student();
        s2.name = "播仔";
        s2.chinese = 50;
        s2.math = 100;
        s2.printAllScore();
        s2.printAverageScore();
        System.out.println(s2);
    }
}
