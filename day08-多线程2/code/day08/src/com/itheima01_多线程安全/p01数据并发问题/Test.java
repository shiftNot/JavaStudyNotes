package com.itheima01_多线程安全.p01数据并发问题;

/*
多线程安全问题
    1.概述
    	多个线程同一时间段运行同一段代码。程序最终结果和单线程运行结果一致，且其他变量的值和预期也一致，就是线程安全的
    2.问题演示
    	假设有100张电影票，需要从4个窗口同时出售这100张票，用线程模拟该场景
    	采用线程对象模拟多个窗口，因为票是被四个窗口共享的，所以可以使用Runnable实现类存储票的变量，并定义买票动作
    3.问题总结：1.同票    2.不存在的票    3.丢票
    4.问题分析
    	1.同票 参考《卖票问题-同票》
    	2.不存在的票 参考《卖票问题-不存在的票》
    	3.丢票 参考《卖票问题-丢票》
    6.解决办法
    	原因：在多线程环境下，共享内容，被多个位置多次操作。
    	解决思路：哪里有问题，包裹哪里，不让其他线程干预
    	解决办法:线程同步
     		多个线程共享同一段操作，一个线程获取执行权限期间，其他线程不能获取这段操作的执行权限。
     		直到该线程释放权限后，被同步的线程和该线程一起重新取抢夺CPU资源，直到完成所有操作。
    	同步机制的三中方式：同步代码块、同步方法、Lock锁
同步代码块
    1.概述
    	synchronized关键字可以用于方法中的某个区块中，表示只对这个区块的资源实行互斥访问。
    2.格式
    	synchroized(同步锁对象){
    		需要同步的操作
    	}
    	对象的同步锁只是一个标记作用，锁对象 可以是任意类型
    	多个线程对象，想要达到线程同步，需要使用同一把锁对象
同步方法
    1.概述
        synchronized修饰的方法,叫做同步方法，表示只对这个方法中的资源实行互斥访问。
    2.格式
        public synchroized [static] 返回值类型 (形参列表){
            需要同步的操作
        }
        静态同步方法锁对象 :方法所在类的字节码对象(类名.class)
        非静态同步方法锁对象 :this
Lock锁
    1.概述
    	java.util.concurrent.locks.Lock机制提供了比同步代码块和同步方法更广泛的锁定操作。
    	Lock是一个接口，需要使用其实现类ReentrantLock来创建对象，使用具体的功能
    2.构造方法
    	public ReentrantLock(){}
    3.常用方法
    	public void lock() 加同步锁。
    	public void unlock() 释放同步锁。
*/
public class Test {
    public static void main(String[] args) {
        //创建任务对象(Runnable实现类对象)
        //有问题的实现类
        //TicketRunnable tr = new TicketRunnable();
        //使用同步代码块解决线程安全问题
        //TicketRunnable2 tr = new TicketRunnable2();
        //使用同步方法决线程安全问题
        //TicketRunnable3 tr = new TicketRunnable3();
        //使用Lock锁决线程安全问题
        TicketRunnable4 tr = new TicketRunnable4();
        //创建四个线程，表示四个窗口，执行卖100张票的操作
        Thread t1 = new Thread(tr, "窗口一:");
        Thread t2 = new Thread(tr, "窗口二:");
        Thread t3 = new Thread(tr, "窗口三:");
        Thread t4 = new Thread(tr, "窗口四:");
        //启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
