package com.entor.socket;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.LinkedList;

public class TestServerWriteThread implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(2000);
                if (TestThreadServer.map.size() == 0)// �ͻ��˿��ܽ��������ӣ�����û���˷�����Ϣ
                    continue;
                //  ���˷��͹���Ϣ������socket
                for (Socket socket : TestThreadServer.map.keySet()) {
                    LinkedList<String> message = TestThreadServer.map.get(socket);// �õ�ÿ��socket��Ӧ����Ϣ��
                    while (message.size() != 0) {
                        if (message.peek() != null) {
                            for (Socket s2 : TestThreadServer.map.keySet()) {
                                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s2.getOutputStream()));
                                bw.write(socket.getRemoteSocketAddress() + "˵��" + message.peek() + "\r\n");
                                bw.flush();
                            }
                            message.poll();// �Ƴ���ͷ��Ϣ
                        }

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
