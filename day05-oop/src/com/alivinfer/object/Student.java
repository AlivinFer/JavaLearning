package com.alivinfer.object;

/**
 * @author Fer
 * @version 1.0
 * @description 学生类
 * @date 2025/1/20
 */

public class Student {
    String name;
    double chinese;
    double math;

    public void printAllScore(){
        System.out.println(name + "的总成绩是：" +
                (chinese + math));
    }

    public void printAverageScore(){
        System.out.println(name + "的平均成绩是：" +
                (chinese + math) / 2);
    }
}
