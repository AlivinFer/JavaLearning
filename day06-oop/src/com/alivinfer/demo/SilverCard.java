package com.alivinfer.demo;

/**
 * @author Fer
 * @version 1.0
 * @description 银卡
 * @date 2025/1/21
 */

public class SilverCard extends Card{
    public SilverCard(String cardId, String carOwnerName, String phoneNumber, double cardBalance, double discount) {
        super(cardId, carOwnerName, phoneNumber, cardBalance, discount);
    }

    @Override
    public void consume(double money) {
        System.out.println("您当前银卡消费：" + money);
        System.out.println("优惠后的价格：" + money * discount);
        if (getCardBalance() < money * discount) {
            System.out.println("您余额是：" + getCardBalance() + ", 当前余额不足！请存钱！");
            return;
        }
        // 更新银卡余额
        setCardBalance(getCardBalance() - money * discount);
    }


}
