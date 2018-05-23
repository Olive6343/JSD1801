package com.entor.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class ReadThreadTest {
    public static void main(String[] args) {
        // 1.创建键盘输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 2.创建缓冲区
        LinkedList<String> message = new LinkedList<>();
        // 3.创建读线程
        Thread readThread = new Thread(new ReadThread(br, message));
        // 4.启动读线程
        readThread.start();
    }
}
