package com.itheima.demo09_单例设计模式;

public class Student_懒汉式 {
    /*
        懒汉式实现步骤：
                1. 将构造方法私有化；
                2. 内部定义私有、静态本类类型成员属性，初始值为null；
                3. 提供公有、静态方法，获取该类的唯一对象；
                4. 在方法内，先判断成员属性是否为null：
                    为null : 创建对象；
                   不为null: 返回这个引用。

        懒汉式的特点：
            1.只有当调用公有静态方法时才会创建出该类唯一的对象  延迟加载
            2.懒汉式单例模式 多线程环境下不安全
                解决：
                    1.加锁   同步方法
                    2.加锁   同步代码块

     */

    //1.构造方法私有化
    private Student_懒汉式(){}

    //2.直接创建出对象 保证可见性
    private volatile static Student_懒汉式 student;

    //3.提供公有的静态方法访问


    //不加锁    20分
    /* public synchronized static Student_懒汉式 getInstance(){

        if (student==null){
            student = new Student_懒汉式();
        }

        return student;
    }*/

    //同步方法  40分
   /* public synchronized static Student_懒汉式 getInstance(){

        if (student==null){
            student = new Student_懒汉式();
        }

        return student;
    }*/

    //同步代码块  60分
    /*public  static Student_懒汉式 getInstance(){

        synchronized (Student_懒汉式.class) {
            if (student==null){
                student = new Student_懒汉式();
            }
        }

        return student;
    }*/

    //同步代码块加if判断  +  在声明单例对象时使用volatile  保证可见性  【双重检查】 80分|100分
    public  static Student_懒汉式 getInstance(){

        if(student==null){
            synchronized (Student_懒汉式.class) {
                if (student==null){
                    student = new Student_懒汉式();
                }
            }
        }

        return student;
    }

    //100分 枚举实现  欲知后事如何 请听下回分解
}
