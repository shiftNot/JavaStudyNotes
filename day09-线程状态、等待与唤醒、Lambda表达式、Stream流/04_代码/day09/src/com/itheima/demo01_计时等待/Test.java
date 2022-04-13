package com.itheima.demo01_计时等待;

public class Test {
    /*
        计时等待：
            1.使用Thread类的静态方法sleep(long time)
            2.使用Object类的wait方法wait(long time) 注意：必须加锁，使用锁对象调用wait方法
     */

    //psvm | main 按一下tab键
    public static void main(String[] args) throws InterruptedException {

        //方式一：sleep实现计时等待
        /*for (int i = 0; i < 10; i++) {
            //i.soutv
            System.out.println("i = " + i);
            //睡眠
            Thread.sleep(1000);
        }*/

        //方式二：通过wait(long time)实现计时等待
        //注意：
        // 1.调用wait方法时，线程需要加锁  需要使用锁对象调用wait方法
        // 2.锁对象指的是放在synchronized括号中的对象
       new Thread(new Runnable() {
           @Override
           public void run() {
               for (int i = 0; i < 10; i++) {
                  synchronized ("A锁"){
                      //i.soutv
                      System.out.println("i = " + i);
                      //睡眠
                      try {
                          "A锁".wait(1000);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
               }
           }
       }).start();

    }
}
