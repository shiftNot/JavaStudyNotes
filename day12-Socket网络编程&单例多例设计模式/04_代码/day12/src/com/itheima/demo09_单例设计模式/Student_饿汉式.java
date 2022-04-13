package com.itheima.demo09_单例设计模式;

public class Student_饿汉式 {
    /*
        饿汉式实现步骤：
            1.将构造方法私有化,确保在类的外部不能通过new来创建对象
            2.在本类中创建该类的唯一对象
            3.提供公共的访问方式来访问该类的唯一对象  公共静态方法
        饿汉式的特点：
            1.类一加载 对象就创建好了 只创建了一个  不管你使用不使用 都已经创建好了
            2.饿汉式单例设计模式是线程安全的 立即加载

     */

    //1.构造方法私有化
    private Student_饿汉式(){}

    //2.直接创建出对象
    private static Student_饿汉式 student = new Student_饿汉式();

    //3.提供公有的静态方法访问
    public static Student_饿汉式 getInstance(){
        return student;
    }
}
