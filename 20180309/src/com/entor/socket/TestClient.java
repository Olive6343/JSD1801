package com.entor.socket;

import java.io.*;
import java.net.Socket;

/**
 * 服务器与客户端之间的交流通过网络输入输出字节流进行的
 */
public class TestClient {
    public static void main(String[] args) throws Exception {
        // 1.创建客户端套接字，请求服务器
        Socket socket = new Socket("127.0.0.1", 7878);
        // 2.开始通信，向服务点发送信息
        // 获得网络输出流，并将信息写到输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("服务器，你好！\r\n");
        bw.flush();
        // 获得网络输入流，接收客户端信息并输出
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("【服务端】-" + br.readLine());
    }
}
