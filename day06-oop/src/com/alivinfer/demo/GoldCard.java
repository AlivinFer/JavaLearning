package com.alivinfer.demo;

/**
 * @author Fer
 * @version 1.0
 * @description 金卡
 * @date 2025/1/21
 */

public class GoldCard extends Card{
    public GoldCard(String cardId, String carOwnerName, String phoneNumber, double cardBalance, double discount) {
        super(cardId, carOwnerName, phoneNumber, cardBalance, discount);
    }

    @Override
    public void consume(double money) {
        System.out.println("您当前金卡消费：" + money);
        System.out.println("优惠后的价格：" + money * discount);
        if (getCardBalance() < money * discount) {
            System.out.println("您余额是：" + getCardBalance() + ", 当前余额不足！请存钱！");
            return;
        }
        // 更新金卡余额
        setCardBalance(getCardBalance() - money * discount);
        if (money * discount >= 200) {
            printTicket();
        } else {
            System.out.println("您当前消费不满200，不能免费洗车！");
        }
    }

    // 打印洗车票。
    public void printTicket() {
        System.out.println("您消费了，请打印洗车票。");
    }
}
