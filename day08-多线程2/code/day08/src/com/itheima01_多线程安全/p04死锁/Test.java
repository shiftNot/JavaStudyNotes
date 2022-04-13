package com.itheima01_多线程安全.p04死锁;

/*
1.概述
	在多线程程序中,使用了多把锁,造成线程之间相互等待.程序不往下走了，即为死锁
	实际开发应尽量避免线程死锁。
2.死锁产生条件
	有多把锁
	有多个线程
	有线程同步嵌套

需求:演示死锁代码
*/
public class Test {
    public static void main(String[] args) {
        //两把锁
        Object lockA = new Object();
        Object lockB = new Object();
        //多个线程
        new Thread("线程1") {
            @Override
            public void run() {
                while (true) {
                    System.out.println(getName() + "等待获取A锁");
                    synchronized (lockA) {
                        System.out.println(getName() + "获取A锁");//暂停
                        System.out.println(getName() + "等待获取B锁");
                        synchronized (lockB) {
                            System.out.println(getName() + "获取B锁");
                        }
                    }
                }
            }
        }.start();

        new Thread("线程2") {
            @Override
            public void run() {
                while (true) {
                    System.out.println(getName() + "等待获取B锁");
                    synchronized (lockB) {
                        System.out.println(getName() + "获取B锁");//暂停
                        System.out.println(getName() + "等待获取A锁");
                        synchronized (lockA) {
                            System.out.println(getName() + "获取A锁");
                        }
                    }
                }
            }
        }.start();
    }
}









