package com.itheima03_多态.p03多态表现形式;

/*
多态的3中表现形式
    普通父类引用指向子类对象
    抽象父类引用指向子类对象
    父接口引用指向实现类对象

 */
public class Test {
    public static void main(String[] args) {
        //普通父类引用指向子类对象
        Fu1 f1 = new Zi1();
        //抽象父类引用指向子类对象
        Fu2 f2= new Zi2();
        //父接口引用指向实现类对象
        Fu3 f3 = new Zi3();
    }
}

