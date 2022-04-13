package com.itheima01_多线程安全.p02可见性问题;

public class VoaltileThread extends Thread {
    //public  boolean flag = false;
    //使用volatile解决可见性问题
    public volatile boolean flag = false;

    @Override
    public void run() {
        System.out.println("3秒中之后，子线程将修改flag的值");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //同步代码块解决可见性问题
       /*synchronized (this){
           flag = true;
       }*/
        flag = true;
        System.out.println("flag的值被修改为了:" + flag);
    }
}
