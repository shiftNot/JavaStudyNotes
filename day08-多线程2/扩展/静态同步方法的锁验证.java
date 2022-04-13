package com.itheima01_多线程安全;

public class 静态同步方法的锁验证 {
    public static void main(String[] args) throws InterruptedException {

        //证明MyThread中静态方法的锁是MyThread2.class对象
        MyThread2 mt2 = new MyThread2();
        mt2.start();
        for (int i = 0; i < 10000; i++) {
            synchronized (MyThread2.class){
                mt2.num++;
            }
        }
        System.out.println("等待 mt2.num计算完成");
        Thread.sleep(3000);
        System.out.println(mt.num);
    }
}


//静态同步方法
class MyThread2 extends Thread {
    static int num = 0;

    @Override
    public void run() {
        method();
    }

    //锁为MyThread.class(当前类的字节码对象)
    public static synchronized void method() {
        for (int i = 0; i < 10000; i++) {
            num++;
        }
    }

}