package com.entor.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) throws Exception {
        // 1.�����������׽���
        ServerSocket ss = new ServerSocket(7878);
        // 2.�����ͻ�������
        System.out.println("�����������ɹ����ȴ��ͻ���...");
        // ��ȡ������׽���
        Socket socket = ss.accept();
        // 3.��ʼͨ��
        System.out.println("���µĿͻ������ӷ���������ʼͨ��...");
        // ������������������տͻ�����Ϣ�����
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("���ͻ��ˡ�-" + br.readLine());
        // ������������������Ϣд�������
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("�ͻ��ˣ���ã�\r\n");
        bw.flush();
    }
}
