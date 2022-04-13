package com.itheima02_代码块;

public class Person {
    {
        System.out.println("构造代码块");
    }

    static {
        System.out.println("静态代码块");
    }

    public Person() {
        System.out.println("无参构造方法");
    }
}
