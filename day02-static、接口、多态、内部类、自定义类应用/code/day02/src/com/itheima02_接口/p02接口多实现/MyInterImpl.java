package com.itheima02_接口.p02接口多实现;

public class MyInterImpl implements MyInterA, MyInterB {
    //重写父接口中的同名抽象方法 只需要重写1次
    public void abstractMethod() {
        System.out.println("实现类重写了接口中同名的抽象方法");
    }

    //父接口中有同名的默认方法，实现类必须重写1次
    public void defaultMethod() {
        System.out.println("实现类重写了接口中同名的默认方法");
    }
}
