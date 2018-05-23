package com.entor.socket;

import javax.xml.crypto.Data;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UdpClient {
    public static void main(String[] args) throws Exception {
        // 1.创建请求
        DatagramSocket client = new DatagramSocket(10002);
        // 2.准备数据报
        byte[] buffer = new byte[]{8, 2, 3, 7, 1};
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length, InetAddress.getLocalHost(), 10001);
        // 3.客户端发送接收数据报
        client.send(packet);
        byte[] bytes = new byte[40];
        DatagramPacket p2 = new DatagramPacket(bytes, bytes.length);
        client.receive(p2);
        System.out.println(Arrays.toString(p2.getData()));
        // 4.关闭客户端
        client.close();
    }
}
