package com.alivinfer.demo;

import java.util.Scanner;

/**
 * @author Fer
 * @version 1.0
 * @description 测试类
 * @date 2025/1/21
 */

public class Test {
    public static void main(String[] args) {
        // 办一张金卡：创建金卡对象。交给一个独立的业务（支付机）来完成：存款，消费。
        GoldCard goldCard = new GoldCard("鄂A88888", "fer", "13655689631", 5000, 0.8);
        goldCard.setDeposit(100);
        pay(goldCard);

        // 办一张银卡：创建银卡对象。交给一个独立的业务（支付机）来完成：存款，消费。
        SilverCard silverCard = new SilverCard("粤A66666", "steven", "18655689631", 2000, 0.9);
        pay(silverCard);
    }

    // 支付机：用一个方法来刷卡： 可能接收金卡，也可能接收银卡
    public static void pay(Card c){
        System.out.println("请刷卡,请您输入当前消费的金额：");
        Scanner sc = new Scanner(System.in);
        double money = sc.nextDouble();
        c.consume(money);
    }
}
