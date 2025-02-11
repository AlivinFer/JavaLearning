package com.alivinfer.demoExecutorService;

import java.util.concurrent.*;

/**
 * @author Fer
 * @version 1.0
 * @description 使用线程池的实现类 ThreadPoolExecutor
 * @date 2025/2/10
 */

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        /*
        参数一：corePoolSize : 指定线程池的核心线程的数量
        参数二：maximumPoolSize：指定线程池的最大线程数量
        参数三：keepAliveTime ：指定临时线程的存活时间
        参数四：unit：指定临时线程存活的时间单位(秒、分、时、天）
        参数五：workQueue：指定线程池的任务队列
        参数六：threadFactory：指定线程池的线程工厂
        参数七：handler：指定线程池的任务拒绝策略（线程都在忙，任务队列也满了的时候，新任务来了该怎么处理）
         */
        try (ExecutorService pool = new ThreadPoolExecutor(3, 5, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy())) {

            // 使用线程池处理任务！看会不会复用线程？
            Runnable target = new MyRunnable();
            // 提交第1个任务 创建第1个线程 自动启动线程处理这个任务
            pool.execute(target);
            // 提交第2个任务 创建第2个线程 自动启动线程处理这个任务
            pool.execute(target);
            // 提交第3个任务 创建第3个线程 自动启动线程处理这个任务
            pool.execute(target);
            pool.execute(target);
            pool.execute(target);
            pool.execute(target);
            // 到了临时线程的创建时机了
            pool.execute(target);
            // 到了临时线程的创建时机了
            pool.execute(target);
            // 到了任务拒绝策略了，忙不过来
            pool.execute(target);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
