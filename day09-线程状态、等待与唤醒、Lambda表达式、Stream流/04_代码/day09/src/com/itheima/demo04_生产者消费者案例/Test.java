package com.itheima.demo04_生产者消费者案例;

public class Test {

    //定义旗帜变量flag
    static boolean flag = false;

    //定义共享的锁对象
    static Object lock = new Object();

    public static void main(String[] args) {
        /*
            生产者消费者案例：
                生产者【包子铺】生产包子
                消费者【吃货】 吃包子
                包子铺每生产一个包子，吃货就吃掉一个包子【有规律执行 需要使用等待唤醒机制】
             具体实现：
                1.定义一个旗帜变量flag=false，默认值为false表示包子铺此时没有包子
                2.包子铺线程：当flag==true时，进入无限等待，当flag==false时，开始生产包子，喊吃货过来吃包子，修改flag=true
                3.吃货线程：当flag==true时，吃货正在吃包子喊包子铺生产包子 修改flag=false，当flag==true时，吃货进入无限等待
         */

        //1.创建包子铺线程 并启动
        BaoZhiPu baoZhiPu = new BaoZhiPu();
        baoZhiPu.start();

        //2.创建吃货线程 并启动
        ChiHuo chiHuo = new ChiHuo();
        chiHuo.start();


    }
}
