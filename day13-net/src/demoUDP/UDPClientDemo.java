package demoUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Fer
 * @version 1.0
 * @description UDP 客户端实现
 * @date 2025/2/11
 */

public class UDPClientDemo {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            String message = "Hello, UDP Server!";
            byte[] data = message.getBytes();
            InetAddress address = InetAddress.getByName("localhost");

            DatagramPacket packet = new DatagramPacket(data, data.length, address, 8080);
            // 发送数据
            socket.send(packet);
            System.out.println("消息已发送！");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
