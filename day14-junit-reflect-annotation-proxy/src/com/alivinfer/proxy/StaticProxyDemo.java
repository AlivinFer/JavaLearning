package com.alivinfer.proxy;

/**
 * @author Fer
 * @version 1.0
 * @description 静态测试类
 * @date 2025/2/13
 */

public class StaticProxyDemo {
    public static void main(String[] args) {
        Service proxy = new StaticProxy(new RealService());
        proxy.execute();
    }
}
