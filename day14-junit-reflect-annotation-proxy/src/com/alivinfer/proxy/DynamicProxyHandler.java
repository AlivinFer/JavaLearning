package com.alivinfer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Fer
 * @version 1.0
 * @description JDK 动态代理
 * @date 2025/2/13
 */

public class DynamicProxyHandler implements InvocationHandler {

    private final Object target;

    public DynamicProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行前...");
        Object result = method.invoke(target, args);
        System.out.println("执行后...");
        return result;
    }
}
