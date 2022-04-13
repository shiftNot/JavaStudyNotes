package com.itheima02_并发包.p04CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class PersonThread extends Thread {
    private CyclicBarrier cb;

    public PersonThread(CyclicBarrier cb) {
        this.cb = cb;
    }

    @Override
    public void run() {
        System.out.println(getName() + "到达会议室......");
        System.out.println(getName() +"等待其他人的到来");
        try {
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + "发表了本次会议的相关建议......");
    }
}
