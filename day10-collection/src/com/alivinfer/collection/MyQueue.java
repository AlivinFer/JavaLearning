package com.alivinfer.collection;

import java.util.LinkedList;

/**
 * @author Fer
 * @version 1.0
 * @description 使用 LinkedList 实现队列（先进先出）
 * @date 2025/2/7
 */

public class MyQueue<T> {
    private LinkedList<T> list = new LinkedList<>();

    // 入队
    public void enqueue(T t) {
        list.addLast(t);
    }

    // 出队
    public T dequeue() {
        return list.removeFirst();
    }

    // 获取队首元素
    public T peek() {
        return list.getFirst();
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // 获取队列长度
    public int size() {
        return list.size();
    }
}
