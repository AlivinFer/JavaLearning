package com.alivinfer.methodReference;

import java.util.Arrays;

/**
 * @author Fer
 * @version 1.0
 * @description 方法引用
 * @date 2025/1/22
 */

public class methodReferenceDemo {
    public static void main(String[] args) {
        String[] names = {"Charlie", "Alice", "Bob", "Dave"};
        printSortedNames(names);
    }

    public static void printSortedNames(String[] names) {
        if (names == null || names.length == 0) {
            System.out.println("The array is empty.");
            return;
        }

        Arrays.sort(names, String::compareToIgnoreCase);
        Arrays.stream(names).forEach(name -> System.out.print(name + " "));
        System.out.println();
    }
}
