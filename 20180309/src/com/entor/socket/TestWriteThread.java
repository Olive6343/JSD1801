package com.entor.socket;

import java.io.BufferedWriter;
import java.util.LinkedList;

public class TestWriteThread implements Runnable {
    private BufferedWriter bw;
    private LinkedList<String> message;

    public TestWriteThread(BufferedWriter bw, LinkedList<String> message) {
        this.bw = bw;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(2000);
                if (message.size() != 0){
                    bw.write(message.poll());
                    bw.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
