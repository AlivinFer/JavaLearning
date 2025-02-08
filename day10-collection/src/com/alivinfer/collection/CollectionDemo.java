package com.alivinfer.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Fer
 * @version 1.0
 * @description 集合类
 * @date 2025/2/6
 */

public class CollectionDemo {
    public static void main(String[] args) {
        // 目标：搞清楚Collection集合的整体特点.
        // 1、List家族的集合：有序、可重复、有索引。
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Java");
        list.add("C");
        list.add("C++");
        // [Java, Java, C, C++] 顺序和添加顺序一致
        System.out.println(list);
        String rs = list.get(0);
        System.out.println(rs);

        // 2、Set家族的集合：无序、不可重复、无索引。
        Set<String> set = new HashSet<>();
        set.add("鸿蒙");
        set.add("Java");
        set.add("Java");
        set.add("C");
        set.add("C++");
        System.out.println(set);
    }
}
