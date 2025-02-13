package com.alivinfer.proxy;

/**
 * @author Fer
 * @version 1.0
 * @description 真实类
 * @date 2025/2/13
 */

public class RealService implements Service {
    @Override
    public void execute() {
        System.out.println("执行真实业务逻辑");
    }
}
