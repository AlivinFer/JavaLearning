package com.alivinfer.demoCreate;

/**
 * @author Fer
 * @version 1.0
 * @description 创建线程-实现 Runnable 接口
 * @date 2025/2/9
 */

public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());

        thread1.start();
        thread2.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程输出：" + i);
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("线程 " + Thread.currentThread().getName() + " 正在执行");
    }
}