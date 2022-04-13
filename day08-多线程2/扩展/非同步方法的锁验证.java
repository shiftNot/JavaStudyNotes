package com.itheima01_多线程安全;

public class 非静态同步方法的锁验证 {
    public static void main(String[] args) throws InterruptedException {
        //证明MyThread中非静态方法的锁是this--->mt对象
        MyThread mt = new MyThread();
        mt.start();
        for (int i = 0; i < 10000; i++) {
            synchronized (mt){
                mt.num++;
            }
        }
        System.out.println("等待 mt.num计算完成");
        Thread.sleep(3000);
        System.out.println(mt.num);

    }
}

//非静态同步方法
class MyThread extends Thread {
    static int num = 0;

    @Override
    public void run() {
        method();
    }

    //锁为当前对象
    public synchronized void method() {
        for (int i = 0; i < 10000; i++) {
            num++;
        }
    }
}
