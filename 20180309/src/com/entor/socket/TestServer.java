package com.entor.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) throws Exception {
        // 1.创建服务器套接字
        ServerSocket ss = new ServerSocket(7878);
        // 2.监听客户端请求
        System.out.println("服务器启动成功，等待客户端...");
        // 获取请求的套接字
        Socket socket = ss.accept();
        // 3.开始通信
        System.out.println("有新的客户端连接服务器，开始通信...");
        // 获得网络输入流，接收客户端信息并输出
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("【客户端】-" + br.readLine());
        // 获得网络输出流，将信息写到输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("客户端，你好！\r\n");
        bw.flush();
    }
}
