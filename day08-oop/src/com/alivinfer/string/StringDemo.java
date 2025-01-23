package com.alivinfer.string;

/**
 * @author Fer
 * @version 1.0
 * @description 字符串使用
 * @date 2025/1/23
 */

public class StringDemo {
    public static void main(String[] args) {
        // 字符串的创建
        String str1 = "Hello";
        String str2 = new String("World");

        // 字符串长度 输出: 5
        System.out.println("Length of str1: " + str1.length());

        // 字符访问 输出: e
        System.out.println("Character at index 1: " + str1.charAt(1));

        // 子字符串 输出: ell
        System.out.println("Substring: " + str1.substring(1, 4));

        // 大小写转换 输出: HELLO
        System.out.println("Uppercase: " + str1.toUpperCase());
        // 输出: world
        System.out.println("Lowercase: " + str2.toLowerCase());

        // 比较字符串 输出: true
        System.out.println("Equals: " + str1.equals("Hello"));
        // 输出: true
        System.out.println("Equals Ignore Case: " + str1.equalsIgnoreCase("hello"));

        // 查找字符或子串 输出: 2
        System.out.println("Index of 'l': " + str1.indexOf('l'));
        // 输出: 3
        System.out.println("Last Index of 'l': " + str1.lastIndexOf('l'));

        // 替换 输出: Hexxo
        System.out.println("Replace 'l' with 'x': " + str1.replace('l', 'x'));

        // 检查前缀和后缀 输出: true
        System.out.println("Starts with 'He': " + str1.startsWith("He"));
        // 输出: true
        System.out.println("Ends with 'lo': " + str1.endsWith("lo"));

        // 分割字符串
        String csv = "apple,banana,cherry";
        String[] fruits = csv.split(",");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        // 输出:
        // apple
        // banana
        // cherry

        // 拼接字符串
        String joined = String.join("-", "Java", "is", "fun");
        // 输出: Java-is-fun
        System.out.println("Joined string: " + joined);
    }
}
