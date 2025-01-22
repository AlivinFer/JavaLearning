package com.alivinfer.demo;

import java.util.Scanner;

/**
 * @author Fer
 * @version 1.0
 * @description 测试类
 * @date 2025/1/22
 */

public class Test {
    public static void main(String[] args) {
        JD[] jds = new JD[4];
        jds[0] = new JD("TV", true);
        jds[1] = new JD("WashMachine", false);
        jds[2] = new JD("Lamp", true);
        jds[3] = new JD("AirConditioner", false);

        SmartHomeControl smartHomeControl = new SmartHomeControl();
        // 打印全部设备的开和关的现状。
        while (true) {
            smartHomeControl.printAllStatus(jds);
            System.out.println("请您选择要控制的设备：");
            Scanner sc = new Scanner(System.in);
            String command = sc.next();
            switch (command){
                case "1":
                    smartHomeControl.control(jds[0]);
                    break;
                case "2":
                    smartHomeControl.control(jds[1]);
                    break;
                case "3":
                    smartHomeControl.control(jds[2]);
                    break;
                case "4":
                    smartHomeControl.control(jds[3]);
                    break;
                case "exit":
                    System.out.println("退出App!");
                    return;
                default:
                    System.out.println("输入有误，请重新输入");
            }
        }
    }
}
