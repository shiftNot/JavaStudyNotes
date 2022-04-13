package com.itheima01_多线程安全.p03原子性问题;

import java.util.concurrent.atomic.AtomicInteger;

public class CountThread extends Thread {
    //public int count = 0;
    //volatile修饰变量，不能解决原子性问题
    //public volatile int count = 0;
    //AtomicInteger count = new AtomicInteger(0);
    AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            //使用同步机制解决原子性问题
            //synchronized (this) {
            //    count++;
            //}
            count.incrementAndGet();
        }
        System.out.println("子线程已结束");
    }
}
