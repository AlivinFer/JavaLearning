package com.alivinfer.demoSynchronized;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fer
 * @version 1.0
 * @description 银行账户类
 * @date 2025/2/10
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    /**
     * 卡号
     */
    private String carId;

    /**
     * 余额
     */
    private double money;

    // 小明和小红都到这里来取钱
    public void drawMoney(double money) {
        // 拿到当前谁来取钱
        String name = Thread.currentThread().getName();
        synchronized (this) {
            // 判断余额是否足够
            if (this.money >= money) {
                // 余额足够，取钱
                System.out.println(name + "取钱成功，吐出了" + money + "元成功！");
                // 更新余额
                this.money -= money;
                System.out.println(name + "取钱成功，取钱后，余额剩余" + this.money + "元");

            } else {
                // 余额不足
                System.out.println(name + "取钱失败，余额不足");
            }
        }
    }
}
