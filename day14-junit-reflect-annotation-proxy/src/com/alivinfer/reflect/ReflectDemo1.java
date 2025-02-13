package com.alivinfer.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author Fer
 * @version 1.0
 * @description 反射获取构造方法并创建对象
 * @date 2025/2/12
 */

public class ReflectDemo1 {
    public static void main(String[] args) throws Exception {
        // 获取 Class 对象
        Class<?> clazz = Class.forName("com.alivinfer.reflect.Person");

        // 获取构造方法
        Constructor<?> constructor = clazz.getConstructor(String.class);

        // 创建实例
        Object person = constructor.newInstance("Alice");

        // 调用方法
        Method method = clazz.getMethod("sayHello");
        method.invoke(person);
    }
}
