package com.alivinfer.reflect;

/**
 * @author Fer
 * @version 1.0
 * @description 反射获取 class 对象
 * @date 2025/2/12
 */

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1. 通过 类名.class
        Class<?> c = String.class;
        System.out.println("类名.class: " + c);

        // 2. 通过 对象.getClass()
        String str = "Hello";
        Class<?> c1 = str.getClass();
        System.out.println("对象.class: " + c1);

        // 3. 通过 Class.forName("全限定类名")
        Class<?> c2 = Class.forName("java.lang.String");
        System.out.println("Class.forName(\"全限定类名\"): " + c2);
    }
}
