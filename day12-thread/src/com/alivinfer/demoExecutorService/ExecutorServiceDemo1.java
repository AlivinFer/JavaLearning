package com.alivinfer.demoExecutorService;

import java.util.concurrent.*;

/**
 * @author Fer
 * @version 1.0
 * @description 使用线程池处理Callable任务
 * @date 2025/2/11
 */

public class ExecutorServiceDemo1 {
    public static void main(String[] args) {
        try (ExecutorService pool = new ThreadPoolExecutor(3, 5,
                10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());) {

            Future<String> f1 = pool.submit(new MyCallable(100));
            Future<String> f2 = pool.submit(new MyCallable(200));
            Future<String> f3 = pool.submit(new MyCallable(300));
            Future<String> f4 = pool.submit(new MyCallable(400));

            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
            System.out.println(f4.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
