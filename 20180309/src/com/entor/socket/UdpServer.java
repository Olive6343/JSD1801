package com.entor.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UdpServer {
    public static void main(String[] args) throws Exception {
        // 1.创建监听
        DatagramSocket server = new DatagramSocket(10001);
        // 2.准备数据报
        byte[] buffer = new byte[200];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        // 3.服务端接收数据包
        server.receive(packet);
        System.out.println("收到" + packet.getAddress() + "的来信，内容是：" + Arrays.toString(packet.getData()));
        byte[] b2 = new byte[]{1, 2, 3, 4, 5};
        DatagramPacket packet2 = new DatagramPacket(b2, 0, b2.length, InetAddress.getLocalHost(), 10002);
        // 3.客户端发送接收数据报
        server.send(packet2);
        // 4.关闭服务
        server.close();
    }
}
