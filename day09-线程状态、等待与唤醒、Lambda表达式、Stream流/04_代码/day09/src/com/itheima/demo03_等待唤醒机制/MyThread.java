package com.itheima.demo03_等待唤醒机制;

public class MyThread extends Thread{

    //子线程：打印100次j循环
    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            synchronized (Test.lock){
                //当旗帜变量flag为true时，子线程进入无限等待状态
                if(Test.flag==true){
                    //无限等待
                    try {
                        Test.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //当旗帜变量flag为false是，打印j循环，唤醒主线程，修改旗帜变量flag=true
                if(Test.flag==false){
                    //打印j循环
                    System.out.println("子线程第"+j+"次打印j循环");
                    //唤醒主线程
                    Test.lock.notify();
                    //修改旗帜变量flag=true
                    Test.flag=true;
                }

            }
        }
    }
}
