package com.itheima02_接口.p05接口与接口多继承;

public interface MyInterImpl extends MyInterA, MyInterB {
    //可以不重写同名的抽象方法

    //必须重写父接口中同名的默认方法
    public default void defaultMethod() {
        System.out.println("重写父接口中同名的默认方法");
    }
}
