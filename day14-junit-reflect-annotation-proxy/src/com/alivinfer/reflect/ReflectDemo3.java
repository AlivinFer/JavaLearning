package com.alivinfer.reflect;

import java.lang.reflect.Method;

/**
 * @author Fer
 * @version 1.0
 * @description 反射获取调用方法
 * @date 2025/2/12
 */

public class ReflectDemo3 {
    public static void main(String[] args) throws Exception{
        // 获取 Class 对象
        Class<?> clazz = Calculator.class;

        // 获取方法对象
        Method method = clazz.getMethod("add", int.class, int.class);

        Method method1 = clazz.getDeclaredMethod("subtract", int.class, int.class);

        // 允许访问私有方法
        method1.setAccessible(true);

        // 创建实例
        Object calculator = clazz.getDeclaredConstructor().newInstance();

        // 调用方法
        Object result = method.invoke(calculator, 5, 3);
        System.out.println("结果: " + result);

        Object result1 = method1.invoke(calculator, 5, 3);
        System.out.println("减法结果：" + result1);
    }
}
