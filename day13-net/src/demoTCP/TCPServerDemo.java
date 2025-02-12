package demoTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Fer
 * @version 1.0
 * @description TCP 服务端实现
 * @date 2025/2/11
 */

public class TCPServerDemo {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("服务器已启动，等待客户端连接...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("客户端已连接：" + socket.getInetAddress() + "/" + socket.getPort());

                // 读取客户端发送的数据
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message = reader.readLine();
                System.out.println("收到客户端消息：" + message);

                // 发送响应
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                writer.println("服务器已收到消息：" + message);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
