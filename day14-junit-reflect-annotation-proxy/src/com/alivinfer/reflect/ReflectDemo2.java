package com.alivinfer.reflect;

import java.lang.reflect.Field;

/**
 * @author Fer
 * @version 1.0
 * @description 反射获取操作类的字段
 * @date 2025/2/12
 */

public class ReflectDemo2 {
    public static void main(String[] args) throws Exception{
        Class<?> clazz = Person.class;

        // 获取字段对象（包括私有字段）
        Field field = clazz.getDeclaredField("fieldName");

        // 由于是 private 访问，需要设置可访问
        field.setAccessible(true);

        Person person = new Person();

        // 获取字段值
        System.out.println("原始值: " + field.get(person));

        // 修改字段值
        field.set(person, "Alice");

        // 再次获取字段值
        System.out.println("修改后: " + field.get(person));

    }
}
