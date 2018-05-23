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
        // 1.创建服务器套接字
        ServerSocket ss = new ServerSocket(7878);
        // 2.监听客户端请求
        System.out.println("服务器启动成功，等待客户端...");
        // 死循环，监听多个客户端
        while (true) {
            // 获取请求的套接字
            Socket socket = ss.accept();
            // 3.开始通信
            System.out.println(socket.getRemoteSocketAddress() + "连接服务器，开始通信...");
            map.put(socket, new LinkedList<String>());
            // 获得网络输入流，接收客户端信息并输出
            Thread readThread = new Thread(new TestServerReadThread(socket));
            // 获得网络输出流，将信息写到输出流
            Thread writeThread = new Thread(new TestServerWriteThread());
            readThread.start();
            writeThread.start();
        }
    }
}
