package com.alivinfer.demoSynchronized;

/**
 * @author Fer
 * @version 1.0
 * @description 线程安全 synchronized
 * @date 2025/2/10
 */

public class ThreadDemo {
    public static void main(String[] args) {
        // 线程同步的方式：同步代码块
        Account acc1 = new Account("ICBC-110", 100000);

        new DrawThread("小天", acc1).start();
        new DrawThread("小豪", acc1).start();

    }
}
