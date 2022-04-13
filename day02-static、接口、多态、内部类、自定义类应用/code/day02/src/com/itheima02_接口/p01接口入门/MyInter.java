package com.itheima02_接口.p01接口入门;

public interface MyInter {
    // 静态常量
    //int NUM = 10;//public static final可以省略的，但是不建议。
    public static final int NUM = 10;

    // 抽象方法
    //void abstractMethod();//public abstract可以省略的，但是不建议。
    public abstract void abstractMethod();

    // 默认方法==成员方法(非静态，且有方法体的方法)
    // void defaultMethod() {}//默认方法的default不能省略的
    public default void defaultMethod() {
        System.out.println("接口中的默认方法1");
    }

    public default void defaultMethod2() {
        System.out.println("接口中的默认方法2");
    }

    // 静态方法
    //void staticMethod() {}//静态方法的static不能省略的
    public static void staticMethod() {
        System.out.println("接口中的静态方法");
    }
}
