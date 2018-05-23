package com.entor.thread;

import java.io.BufferedWriter;
import java.util.LinkedList;

public class WriteThread implements Runnable {
    private BufferedWriter bw;
    private LinkedList<String> message;

    public WriteThread(BufferedWriter bw, LinkedList<String> message) {
        this.bw = bw;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (message.size() == 0) {
                    System.out.println("缓冲区没有数据，休眠五秒...");
                    Thread.sleep(5000);
                } else {
                    String header = message.poll();// 获得队列第一个元素
                    if ("quit".equals(header)) {
                        break;// 遇到读线程结束标记，写线程也随之结束
                    }
                    System.out.println("正在写入队列头元素...");
                    bw.write(header);
                    bw.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("写线程结束...");
            }
        }
    }
}
