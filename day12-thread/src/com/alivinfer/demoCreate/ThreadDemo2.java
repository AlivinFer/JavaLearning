package com.alivinfer.demoCreate;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author Fer
 * @version 1.0
 * @description 创建线程-实现 Callable 接口
 * @date 2025/2/9
 */

public class ThreadDemo2 {
    public static void main(String[] args) {
        Callable<String> c1 = new MyCallable(100);

        /*
          未来任务对象的作用？
             a、本质是一个Runnable线程任务对象，可以交给Thread线程对象处理
             b、可以获取线程执行完毕后的结果
         */
        // public FutureTask(Callable<V> callable)
        FutureTask<String> f1 = new FutureTask<>(c1);
        // 把FutureTask对象作为参数传递给Thread线程对象。
        Thread t1 = new Thread(f1);
        // 6、启动线程。
        t1.start();

        Callable<String> c2 = new MyCallable(50);
        FutureTask<String> f2 = new FutureTask<>(c2);
        Thread t2 = new Thread(f2);
        t2.start();

        // 获取线程执行完毕后返回的结果
        try {
            // 如果主线程发现第一个线程还没有执行完毕，会让出CPU，等第一个线程执行完毕后，才会往下执行！
            System.out.println(f1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // 如果主线程发现第二个线程还没有执行完毕，会让出CPU，等第一个线程执行完毕后，才会往下执行！
            System.out.println(f2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyCallable implements Callable<String> {
    private int n;
    public MyCallable(int n) {
        this.n = n;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return "子线程计算1-" + n + "的和是："  + sum;
    }
}
