package com.itheima02_接口.p03继承并实现;

public interface MyInter {
    // 静态常量
    public static final int NUM = 999;

    // 抽象方法
    public abstract void abstractMethod();

    // 默认方法
    public default void defaultMethod() {
        System.out.println("接口中的默认方法");
    }

    // 静态方法
    public static void staticMethod() {
        System.out.println("接口中的静态方法");
    }
}
