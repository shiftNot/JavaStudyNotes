package com.itheima02_并发包.p05Semaphore;

import java.util.concurrent.Semaphore;

public class MyThread extends Thread {
    private Semaphore sp;

    public MyThread(Semaphore sp) {
        this.sp = sp;
    }

    @Override
    public void run() {
        //获取执行许可 记录已获取执行许可的个数
        try {
            sp.acquire();
            System.out.println(getName() + "获取了执行的机会"+System.currentTimeMillis());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //释放许可
        sp.release();

    }
}
