package com.alivinfer.reflect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fer
 * @version 1.0
 * @description Person 类
 * @date 2025/2/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private String fieldName = "Bob";

    public void sayHello() {
        System.out.println("Hello, my name is " + name);
    }
}
