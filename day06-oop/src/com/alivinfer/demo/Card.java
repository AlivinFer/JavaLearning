package com.alivinfer.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Fer
 * @version 1.0
 * @description 卡片类
 * @date 2025/1/21
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    /**
     * 车牌号码
     */
    private String cardId;
    /**
     * 车主姓名
     */
    private String carOwnerName;
    /**
     * 车主电话号码
     */
    private String phoneNumber;
    /**
     * 卡片余额
     */
    private double cardBalance;

    /**
     * 折扣，默认无
     */
    protected double discount = 1.0;

    /**
     * 充值
     * @param money 充值金额
     */
    public void setDeposit(double money) {
        this.cardBalance += money;
    }

    /**
     * 消费
     * @param money 消费金额
     */
    public void consume(double money) {
        if (this.cardBalance >= money) {
            this.cardBalance -= money;
        } else {
            System.out.println("余额不足");
        }
    }
}
