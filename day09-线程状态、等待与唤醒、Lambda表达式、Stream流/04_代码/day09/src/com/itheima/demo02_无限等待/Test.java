package com.itheima.demo02_无限等待;

public class Test {

    //声明 共享的锁对象  保证多个线程使用的是同一把锁
    static String lock = "A锁";

    public static void main(String[] args) {
        /*
            无限等待：
                Object类的方法：
                     void wait() ：当前线程的锁对象调用wait方法，当前线程进入无限等待状态，等待其他线程唤醒
                     void notify()：锁对象调用notify方法，唤醒单个无限等待状态的线程
                     void notifyAll()：锁对象调用notifyAll方法，唤醒所有相同锁对象的无限等待线程
            实现等待和唤醒：
                1.一定要使用锁对象调用wait方法让当前线程进入无限等待
                2.一定要使用锁对象调用notify和notifyAll方法唤醒其他的无限等待线程
                3.调用wait、notify、notifyAll方法的锁对象必须是同一个
            分析：
                1.锁对象调用wait方法，进入无限等待，会释放锁对象和CPU，并且不会再参与争夺，直到被其他线程唤醒
                2.锁对象调用notify方法，唤醒其他无限等待线程，不会立即释放锁对象和CPU，只有当前线程代码执行完毕才会释放锁对象
                3.线程依然是抢占式执行，如果线程2先获取到锁对象执行唤醒，那么线程2执行完释放锁之后，线程1执行就会一直处于无限等待状态
                4.无限等待线程被唤醒，重新拿到锁对象后，会从进入无限等待的位置继续往下执行
         */



        //创建线程1并启动 让其进入无限等待状态
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("线程1：准备调用wait方法进入无限等待状态");
                    try {
                        //无限等待
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1：被其他线程唤醒了，继续执行...");
                }
            }
        }).start();

        //线程2：唤醒其他无限等待线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println("线程2：准备调用notify方法唤醒无限等待线程...");
                    lock.notify();
                    System.out.println("线程2：唤醒完毕...");
                }//释放锁对象
            }
        }).start();

    }
}
