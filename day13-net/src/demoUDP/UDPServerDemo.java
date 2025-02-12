package demoUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author Fer
 * @version 1.0
 * @description UDP 服务端
 * @date 2025/2/11
 */

public class UDPServerDemo {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(8080)) {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("UDP 服务器启动，等待数据...");
            // 接收数据
            socket.receive(packet);

            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("收到客户端消息：" + message);

            // 获取对方的ip对象和程序端口
            String ip = packet.getAddress().getHostAddress();
            int port = packet.getPort();
            System.out.println("对方ip：" + ip + "   对方端口：" + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
