package com.entor.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.LinkedList;

public class WriteThreadTest {
    public static void main(String[] args) throws  Exception{
        //1.创建输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("message.txt"));
        //2.创建缓冲区
        LinkedList<String> message = new LinkedList<>();
        message.add("123");
        message.add("aaa");
        message.add("你我他");
        // 3.创建写线程
        Thread writeThread = new Thread(new WriteThread(bw,message));
        // 4.启动写线程
        writeThread.start();
    }
}
