package com.entor.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.LinkedList;

/**
 * 服务器与客户端之间的交流通过网络输入输出字节流进行的
 */
public class TestThreadClient {
    public static void main(String[] args) throws Exception {
        // 1.创建客户端套接字，请求服务器
        Socket socket = new Socket("127.0.0.1", 7878);
        // 2.开始通信，向服务点发送信息
        // 获得网络输出流，并将信息写到输出流
        LinkedList<String> messageFromLocal = new LinkedList<>();
        Thread writeThread = new Thread(new TestWriteThread(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), messageFromLocal));
        // 获得网络输入流，接收客户端信息并输出
        Thread readThread = new Thread(new TestReadThread(new BufferedReader(new InputStreamReader(socket.getInputStream()))));
        writeThread.start();
        readThread.start();

        // 通过录入键盘
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("请输入：");
            messageFromLocal.add(reader.readLine() + "\r\n");
        }
    }
}
