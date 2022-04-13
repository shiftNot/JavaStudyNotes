package com.itheima.demo01_多例_通用对象模式实现;

public class Test {
    public static void main(String[] args) {
        /*
            介绍:
                多例模式(Multiton Pattern)是 Java 中的设计模式之一，属于创建型模式。
                它提供了一种控制创建的对象个数的方式。
            作用：在程序运行期间,保证某个类有且仅能创建固定数量个对象,从而节省内存空间。
            多例设计模式特点:
                1.构造方法要私有化,确保在类的外部不能通过new来创建对象
                2.在本类中创建固定个数的对象
                3.提供公共的访问方式   公共静态方法
            实现方式分类
                通用对象模式：无特殊含义区分的若干对象定义
                特定对象模式: 有特殊含义区分的若干对象定义。
            使用场景：连接池【eg：线程池】

         */

        //测试：获取10次Person类的对象
        for (int i = 0; i < 10; i++) {
            System.out.println(Person.getInstance());
        }

    }
}
