package com.entor.socket;

import java.io.*;
import java.net.Socket;

/**
 * ��������ͻ���֮��Ľ���ͨ��������������ֽ������е�
 */
public class TestClient {
    public static void main(String[] args) throws Exception {
        // 1.�����ͻ����׽��֣����������
        Socket socket = new Socket("127.0.0.1", 7878);
        // 2.��ʼͨ�ţ������㷢����Ϣ
        // ��������������������Ϣд�������
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("����������ã�\r\n");
        bw.flush();
        // ������������������տͻ�����Ϣ�����
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("������ˡ�-" + br.readLine());
    }
}
