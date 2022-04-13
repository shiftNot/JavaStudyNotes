package com.itheima.demo04_生产者消费者案例;

public class BaoZhiPu extends Thread{
    @Override
    public void run() {

        while (true) {
            synchronized (Test.lock){
                //2.包子铺线程：当flag==true时，进入无限等待，当flag==false时，开始生产包子，喊吃货过来吃包子，修改flag=true
                if(Test.flag==true){
                    try {
                        Test.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if(Test.flag==false){
                    System.out.println("包子铺正在生产包子");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("包子铺完成生产包子");
                    Test.lock.notify();
                    Test.flag=true;
                }
            }
        }

    }
}
