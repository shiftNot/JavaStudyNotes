package com.itheima02_接口.p02接口多实现;

public interface MyInterA {
    // 静态常量
    public static final int NUM = 10;

    // 抽象方法
    public abstract void abstractMethod();

    // 默认方法
    public default void defaultMethod() {
        System.out.println("接口中的默认方法A");
    }

    // 静态方法
    public static void staticMethod() {
        System.out.println("接口中的静态方法A");
    }
}
