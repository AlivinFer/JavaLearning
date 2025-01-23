package com.alivinfer.lambda;

import java.util.function.Consumer;

/**
 * @author Fer
 * @version 1.0
 * @description lambda 表达式
 * @date 2025/1/22
 */

public class LambdaDemo {
    public static void main(String[] args) {
        Consumer<String> print = message -> System.out.println(message);
        print.accept("Hello, Lambda!");
    }
}
