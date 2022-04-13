package com.itheima.demo04_生产者消费者案例;

public class ChiHuo extends Thread{
    @Override
    public void run() {
        while (true) {
            synchronized (Test.lock){
                //3.吃货线程：当flag==true时，吃货正在吃包子喊包子铺生产包子 修改flag=false，当flag==true时，吃货进入无限等待
                if(Test.flag==true){
                    System.out.println("吃货正在吃包子");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("吃货吃完包子了");
                    Test.lock.notify();
                    Test.flag=false;
                }

                if(Test.flag==false){
                    try {
                        Test.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
