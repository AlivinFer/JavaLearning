package com.alivinfer.demoCreate;

/**
 * @author Fer
 * @version 1.0
 * @description 创建线程-继承 Thread
 * @date 2025/2/9
 */

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程输出：" + i);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("线程 " + Thread.currentThread().getName() + " 正在执行");
    }
}
