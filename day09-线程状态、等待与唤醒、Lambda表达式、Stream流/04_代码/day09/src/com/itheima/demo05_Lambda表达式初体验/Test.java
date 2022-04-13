package com.itheima.demo05_Lambda表达式初体验;

public class Test {
    public static void main(String[] args) {
        /*
            需求：分别使用匿名内部类和Lambda表达式创建线程对象 执行循环输出100次i打印
         */
        //面向对象编程：必须依靠对象 调用方法来执行代码
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程任务代码1");
            }
        }).start();

        //函数式编程：注重方法的代码实现，不需要依赖对象  执行效果和面向对象编程是一样的 代码更加简洁  作用：简化代码编写
        new Thread(()->{System.out.println("线程任务代码2");}).start();
    }
}
