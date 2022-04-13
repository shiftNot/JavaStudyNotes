package com.itheima01_多线程安全.p01数据并发问题;

public class TicketRunnable implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        //因为要重复的卖票，所以加死循环
        while (true) {
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
    }
}
