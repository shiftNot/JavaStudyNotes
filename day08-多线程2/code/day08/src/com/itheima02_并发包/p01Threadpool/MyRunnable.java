package com.itheima02_并发包.p01Threadpool;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("runnable："+Math.random() * 10);
    }
}
