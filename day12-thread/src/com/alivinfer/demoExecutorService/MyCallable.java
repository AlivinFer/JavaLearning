package com.alivinfer.demoExecutorService;

import java.util.concurrent.Callable;

/**
 * @author Fer
 * @version 1.0
 * @description Callable 接口实现类
 * @date 2025/2/10
 */

public class MyCallable implements Callable<String> {
    private int n;
    public MyCallable(int n) {
        this.n = n;
    }
    // 实现call方法，定义线程执行体
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return Thread.currentThread().getName() +"计算1-" + n + "的和是："  + sum;
    }
}
