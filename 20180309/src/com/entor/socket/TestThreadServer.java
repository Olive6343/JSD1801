package com.entor.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestThreadServer {
    public static Map<Socket, LinkedList> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        // 1.�����������׽���
        ServerSocket ss = new ServerSocket(7878);
        // 2.�����ͻ�������
        System.out.println("�����������ɹ����ȴ��ͻ���...");
        // ��ѭ������������ͻ���
        while (true) {
            // ��ȡ������׽���
            Socket socket = ss.accept();
            // 3.��ʼͨ��
            System.out.println(socket.getRemoteSocketAddress() + "���ӷ���������ʼͨ��...");
            map.put(socket, new LinkedList<String>());
            // ������������������տͻ�����Ϣ�����
            Thread readThread = new Thread(new TestServerReadThread(socket));
            // ������������������Ϣд�������
            Thread writeThread = new Thread(new TestServerWriteThread());
            readThread.start();
            writeThread.start();
        }
    }
}
