package com.alivinfer.demoExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Fer
 * @version 1.0
 * @description 线程池工具类：Executors 使用
 * @date 2025/2/11
 */

public class ExecutorServiceDemo2 {
    public static void main(String[] args) {
        try (ExecutorService pool = Executors.newFixedThreadPool(3);) {

            Future<String> f1 = pool.submit(new MyCallable(10));
            Future<String> f2 = pool.submit(new MyCallable(20));
            Future<String> f3 = pool.submit(new MyCallable(30));
            Future<String> f4 = pool.submit(new MyCallable(40));

            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
            System.out.println(f4.get());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
