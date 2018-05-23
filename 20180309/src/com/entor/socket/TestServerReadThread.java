package com.entor.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.List;

public class TestServerReadThread implements Runnable {
    private Socket socket;
    private BufferedReader br;
    private String address;

    public TestServerReadThread(Socket socket) {
        this.socket = socket;
        this.address = socket.getRemoteSocketAddress().toString();
        try {
            this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("���������߳̿�ʼ...");
            String line;
            while (true) {
                line = br.readLine();
                if (line != null) {
                    LinkedList<String> message = TestThreadServer.map.get(socket);
                    if (message.size() == 0) {// ��socket��һ�η�����Ϣ
                        message.add(line);
                    } else {
                        message.add(line);// ����������Ϣ
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}