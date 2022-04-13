package com.itheima02_接口.p03继承并实现;

public abstract class Fu {
    // 静态常量
    public static final int NUM = 10;

    // 抽象方法
    public abstract void abstractMethod();

    // 默认方法
    public void defaultMethod() {
        System.out.println("父类中的成员方法");
    }

    // 静态方法
    public static void staticMethod() {
        System.out.println("父类中的静态方法");
    }
}
