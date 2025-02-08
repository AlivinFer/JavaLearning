package com.alivinfer.collection;

import java.util.LinkedList;

/**
 * @author Fer
 * @version 1.0
 * @description 使用 LinkedList 实现栈（先进后出）
 * @date 2025/2/7
 */

public class MyStack<T> {
    private LinkedList<T> list = new LinkedList<>();

    // 压栈
    public void push(T t) {
        list.addFirst(t);
    }

    // 出栈
    public T pop() {
        return list.removeFirst();
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // 获取栈顶元素
    public T peek() {
        return list.getFirst();
    }

    // 获取栈的大小
    public int size() {
        return list.size();
    }
}
