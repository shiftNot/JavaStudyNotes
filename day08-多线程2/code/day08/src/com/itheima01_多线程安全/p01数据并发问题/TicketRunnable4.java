package com.itheima01_多线程安全.p01数据并发问题;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//使用Lock锁解决线程安全问题
public class TicketRunnable4 implements Runnable {
    private int ticket = 100;
    //创建Lock锁对象
    //需要保证使用同一个锁对象
    //ReentrantLock lock = new ReentrantLock();
    Lock lock = new ReentrantLock();

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
            //加锁
            lock.lock();
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
            //释放锁
            lock.unlock();
        }
    }

}
