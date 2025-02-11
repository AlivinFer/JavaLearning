package com.alivinfer.demoExecutorService;

/**
 * @author Fer
 * @version 1.0
 * @description Runnable 接口实现类
 * @date 2025/2/10
 */

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "输出：" + i);
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
