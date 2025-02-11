package com.alivinfer.demoSynchronized;

import com.alivinfer.demoThreadSafe.Account;

/**
 * @author Fer
 * @version 1.0
 * @description 取钱线程
 * @date 2025/2/10
 */

public class DrawThread extends Thread {
    private com.alivinfer.demoSynchronized.Account acc;

    public DrawThread(String name, com.alivinfer.demoSynchronized.Account acc) {
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        acc.drawMoney(100000);
    }
}
