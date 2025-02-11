package com.alivinfer.demoThreadSafe;

/**
 * @author Fer
 * @version 1.0
 * @description 模拟线程安全问题
 * @date 2025/2/10
 */

public class ThreadDemo {
    public static void main(String[] args) {
        Account acc = new Account("ICBC-110", 100000);

        // 设计线程类：创建小明和小红两个线程，模拟小明和小红同时去同一个账户取款10万。
        new DrawThread("小明", acc).start();
        new DrawThread("小红", acc).start();
    }
}
