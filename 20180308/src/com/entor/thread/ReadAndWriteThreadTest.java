package com.entor.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class ReadAndWriteThreadTest {
    public static void main(String[] args) throws Exception {
        // 1.创建缓冲区
        LinkedList<String> message = new LinkedList<>();
        // 2.创建输入输出流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter("message.txt"));
        // 3.创建输入输出线程
        Thread readThread = new Thread(new ReadThread(br, message));
        Thread writeThread = new Thread(new WriteThread(bw, message));
        // 4.启动输入输出线程
        readThread.start();
        writeThread.start();
    }
}
