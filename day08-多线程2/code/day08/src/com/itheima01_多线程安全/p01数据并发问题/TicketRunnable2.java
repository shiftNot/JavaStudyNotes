package com.itheima01_多线程安全.p01数据并发问题;

//使用同步代码块解决线程安全问题
public class TicketRunnable2 implements Runnable {
    private int ticket = 100;

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

            //将来，多个线程对象，使用的是同一个Runnable的实现类对象
            //所以这里的锁对象,我们可以使用this
            synchronized (this) {
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
}
