package com.alivinfer.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description Stream 流使用
 * @date 2025/1/22
 */

public class StreamDemo {
    public static void main(String[] args) {
        // 使用可变列表
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "David"));

        // 使用 Stream API 处理数据
        names.stream()
                // 过滤非空且以 A 开头的名字
                .filter(name -> name != null && name.startsWith("A"))
                // 转换为大写
                .map(String::toUpperCase)
                // 排序
                .sorted()
                // 输出: ALICE
                .forEach(System.out::println);
    }
}
