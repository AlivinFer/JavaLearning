package com.alivinfer.proxy;

/**
 * @author Fer
 * @version 1.0
 * @description 静态代理类
 * @date 2025/2/13
 */

public class StaticProxy implements Service {

    private final Service target;

    public StaticProxy(Service target) {
        this.target = target;
    }

    @Override
    public void execute() {
        System.out.println("执行前...");
        target.execute();
        System.out.println("执行后...");
    }
}
