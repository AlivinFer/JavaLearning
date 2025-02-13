package com.alivinfer.annotation;

import java.lang.reflect.Method;

/**
 * @author Fer
 * @version 1.0
 * @description 解析注解
 * @date 2025/2/13
 */

public class AnnotationProcessor {
    public static void main(String[] args) throws Exception {
        Method method = Example.class.getMethod("test");
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("注解值：" + annotation.value());
        }
    }
}
