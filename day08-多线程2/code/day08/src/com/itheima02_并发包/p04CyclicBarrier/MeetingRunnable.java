package com.itheima02_并发包.p04CyclicBarrier;

public class MeetingRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("所有人到齐了，开始会议，请所有人有序发言");
    }
}
