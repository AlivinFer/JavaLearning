package com.alivinfer.demo;

/**
 * @author Fer
 * @version 1.0
 * @description 智能家居控制类
 * @date 2025/1/22
 */

public class SmartHomeControl {
    // 多态。
    public void control(JD jd) {
        System.out.println(jd.getName() + "状态目前是：" + (jd.isStatus() ? "开着" : "关闭！"));
        System.out.println("开始您的操作");
        // 按下开关
        jd.press();
        System.out.println(jd.getName() + "状态已经是：" + (jd.isStatus() ? "开着" : "关闭！"));
    }

    public void printAllStatus(JD[] jds) {
        // 检查输入是否为null或空数组
        if (jds == null || jds.length == 0) {
            System.out.println("没有设备信息");
            return;
        }
        // 使用for循环，根据索引遍历每个设备。
        for (int i = 0; i < jds.length; i++) {
            JD jd = jds[i];
            System.out.println((i + 1) + "," + jd.getName() + "状态目前是：" + (jd.isStatus() ? "开着" : "关闭！"));
        }
    }
}
