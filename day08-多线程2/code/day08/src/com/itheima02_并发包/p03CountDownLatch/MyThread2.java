package com.itheima02_并发包.p03CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class MyThread2 extends Thread {
    private CountDownLatch cdl;

    public MyThread2(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public void run() {
        System.out.println("B");
        cdl.countDown();
    }
}
