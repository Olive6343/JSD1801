package com.entor.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UdpServer {
    public static void main(String[] args) throws Exception {
        // 1.��������
        DatagramSocket server = new DatagramSocket(10001);
        // 2.׼�����ݱ�
        byte[] buffer = new byte[200];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        // 3.����˽������ݰ�
        server.receive(packet);
        System.out.println("�յ�" + packet.getAddress() + "�����ţ������ǣ�" + Arrays.toString(packet.getData()));
        byte[] b2 = new byte[]{1, 2, 3, 4, 5};
        DatagramPacket packet2 = new DatagramPacket(b2, 0, b2.length, InetAddress.getLocalHost(), 10002);
        // 3.�ͻ��˷��ͽ������ݱ�
        server.send(packet2);
        // 4.�رշ���
        server.close();
    }
}
