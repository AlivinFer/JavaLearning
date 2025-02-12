package demoTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Fer
 * @version 1.0
 * @description TCP 客户端
 * @date 2025/2/12
 */

public class TCPClientDemo {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            // 发送消息
            writer.println("Hello, Server!");

            // 读取服务器返回的消息
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("服务器回复：" + reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
