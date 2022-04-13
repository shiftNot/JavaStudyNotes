package com.itheima.demo08_Lambda表达式使用场景;

public class Test {
    public static void main(String[] args) {
        //1.作为变量使用
        Runnable runnable = ()->System.out.println("线程任务代码1...");
        runnable.run();

        //2.作为方法实参使用
        new Thread(()->{System.out.println("线程任务代码2...");}).start();

        //3.作为方法返回值使用
        Runnable runnable1 = getRunnable();
        runnable1.run();

    }

    //3.作为方法返回值使用
    public static Runnable getRunnable(){
        return ()-> System.out.println("线程任务代码3...");
    }
}
