package com.itheima.demo03_等待唤醒机制;

public class Test {

    //定义旗帜变量
    static boolean flag = false;
    //定义共享的锁对象
    static Object lock = new Object();

    public static void main(String[] args) {
        /*
                子线程打印100次j循环  主线程打印100次i循环，要求打印一次j循环之后，再打印一次i循环
                    规律：
                        打印1次j循环，就打印一次i循环
                        ...
                        打印1次j循环，就打印一次i循环
                    分析：就需要使用等待唤醒机制才可以实现有规律的执行
                        打印一次j循环，子线程就进入无限等待，唤醒主线程打印i循环，打印一次i循环
                        打印一次i循环，主线程就进行无限等待，唤醒子线程打印j循环，打印一次j循环
                        xxx情况下：打印1次j循环 唤醒主线程
                        xxx情况下：打印1次i循环 唤醒子线程
                        定义一个成员变量【旗帜变量】，boolean flag = false，默认值
                            子线程：当flag为false时打印j循环，唤醒主线程，为true时，进入无限等待
                            主线程：当falg为true时打印i循环，唤醒子线程，为false是，进入无限等待
                        例子：保安站夜岗：2个人  8-10：A  10-12：B 0-2：A 	2-4：B ...
                    具体实现：
                        定义一个全局旗帜变量flag，设置默认值为false
                        子线程：当flag为false时打印j循环【线程任务】，唤醒主线程，修改flag=true，为true时，进入无限等待
                        主线程：当falg为true时打印i循环【线程任务】，唤醒子线程，修改flag=false，为false时，进入无限等待
                    注意：
                        如果将创建子线程并启动的代码放入主线程代码下方，由于代码自上而下执行，导致wait后面的代码都没有被执行 所以一直卡在那里
                        创建子线程并执行 要放在主线程的前面
                   举一反三：
                        如果想两条线程有规律执行，需要设置旗帜变量，可以使用true|false或者0|1
                        如果有三条线程 交替执行呢：
                            设置一个旗帜变量  int num=1,2,3
                            当num=1：线程1执行  修改num=2，唤醒其他线程 当num！=1时，线程进入无限等待
                            当num=2：线程2执行  修改num=3，唤醒其他线程 当num！=2时，线程进入无限等待
                            当num=3：线程3执行  修改num=1，唤醒其他线程 当num！=3时，线程进入无限等待
                        多思考，思考完成之后 可以动手练习一下
                        学而不思则罔，思而不学则殆

             */


        //创建子线程对象 并且启动线程
        MyThread myThread = new MyThread();
        myThread.start();

        //主线程：打印100次i循环
        for (int i = 0; i < 100; i++) {
            synchronized (lock){
                //当flag为false是，主线程进入无限等待
                if (flag==false){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //当flag为true时，主线程打印i循环  唤醒子线程 修改flag=false
                if(flag==true){
                    //1.主线程打印i循环
                    System.out.println("主线程第"+i+"次打印i循环");
                    // 2.唤醒子线程
                    lock.notify();
                    // 3.修改flag=false
                    flag=false;
                }
            }
        }


    }
}
