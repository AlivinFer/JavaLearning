package com.alivinfer.proxy;

import java.lang.reflect.Proxy;

/**
 * @author Fer
 * @version 1.0
 * @description JDK 动态代理测试类
 * @date 2025/2/13
 */

public class JDKProxyDemo {
    public static void main(String[] args) {
        Service target = new RealService();

        // 创建代理对象
        Service proxy = (Service) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                new Class[]{Service.class},
                new DynamicProxyHandler(target)
        );

        proxy.execute();
    }
}
