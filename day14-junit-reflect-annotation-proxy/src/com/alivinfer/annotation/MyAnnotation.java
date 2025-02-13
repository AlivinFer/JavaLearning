package com.alivinfer.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Fer
 * @version 1.0
 * @description 自定义注解接口
 * @date 2025/2/13
 */

@Retention(RetentionPolicy.RUNTIME) // 指定注解在运行时可用
@Target(ElementType.METHOD) // 指定该注解只能用于方法
@interface MyAnnotation {
    // 定义属性
    String value();
}
