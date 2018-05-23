package com.entor.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.LinkedList;

/**
 * ��������ͻ���֮��Ľ���ͨ��������������ֽ������е�
 */
public class TestThreadClient {
    public static void main(String[] args) throws Exception {
        // 1.�����ͻ����׽��֣����������
        Socket socket = new Socket("127.0.0.1", 7878);
        // 2.��ʼͨ�ţ������㷢����Ϣ
        // ��������������������Ϣд�������
        LinkedList<String> messageFromLocal = new LinkedList<>();
        Thread writeThread = new Thread(new TestWriteThread(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), messageFromLocal));
        // ������������������տͻ�����Ϣ�����
        Thread readThread = new Thread(new TestReadThread(new BufferedReader(new InputStreamReader(socket.getInputStream()))));
        writeThread.start();
        readThread.start();

        // ͨ��¼�����
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("�����룺");
            messageFromLocal.add(reader.readLine() + "\r\n");
        }
    }
}
