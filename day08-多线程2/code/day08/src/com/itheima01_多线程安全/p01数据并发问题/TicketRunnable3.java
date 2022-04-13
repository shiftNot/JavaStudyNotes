package com.itheima01_多线程安全.p01数据并发问题;

//使用同步方法解决线程安全问题
public class TicketRunnable3 implements Runnable {
    private int ticket = 100;
    private static int staticTicket = 100;

    @Override
    public void run() {
        //因为要重复的卖票，所以加死循环
        while (true) {
            //为了体现出来,其他的线程也能执行这个操作，抢的时候，也让每个线程稍微等一下
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //method1();
            method2();
        }
    }

    //将来，多个线程对象，使用的是同一个Runnable的实现类对象 this将来代表同一个对象
    //非静态同步方法--this
    public synchronized void method1() {
        //如果票的数量大于0，才卖票
        if (ticket > 0) {
            //卖出一张票
            System.out.println(Thread.currentThread().getName() + "第" + ticket + "张票正在被卖出...");
            //用线程表示卖票的间歇
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //票数减少
            ticket--;
        }
    }

    //静态同步方法--类的字节码对象(TicketRunnable3.class)
    //每个类的字节码对象一定是唯一的
    public static synchronized void method2() {
        //如果票的数量大于0，才卖票
        if (staticTicket > 0) {
            //卖出一张票
            System.out.println(Thread.currentThread().getName() + "第" + staticTicket + "张票正在被卖出...");
            //用线程表示卖票的间歇
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //票数减少
            staticTicket--;
        }
    }
}
