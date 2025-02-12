package demoInetAddress;

import java.net.InetAddress;

/**
 * @author Fer
 * @version 1.0
 * @description InetAddress 获取本机 IP 对象和对方 IP 对象
 * @date 2025/2/11
 */

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            // 获取本机 IP
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("本地主机名称：" + ip.getHostName());
            System.out.println("本机 IPv4 地址为：" + ip.getHostAddress());

            // 获取对方IP对象
            InetAddress ip2 = InetAddress.getByName("www.baidu.com");
            System.out.println("百度主机名称：" + ip2.getHostName());
            System.out.println("百度 Ipv4 地址为：" + ip2.getHostAddress());

            // 判断本机与对方主机是否互通
            System.out.println(ip2.isReachable(5000));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
