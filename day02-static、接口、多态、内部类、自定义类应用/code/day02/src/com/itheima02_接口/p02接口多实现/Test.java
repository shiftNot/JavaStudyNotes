package com.itheima02_接口.p02接口多实现;

/*
1.介绍：实现类可以同时实现多个接口的，这叫做接口的多实现。
2.多实现格式:[ ]表示可选操作
    public [abstract] public  class 类名 implements 接口名1,接口名2,接口名3... {
        // 重写接口中抽象方法【必须】
        //重写接口中默认方法【不重名时可选】
    }
3.多实现的同名成员使用特点
    多多个父接口中，不同名的内容，按照单实现理解。
    静态常量  只能通过所在接口名调用。
    抽象方法  实现类为非抽象类必须重写1次(含同名)，抽象类，则可以不实现
    默认方法  实现类是否抽象都必须重写1次。
    静态方法  只能通过所在接口名调用。

 */
public class Test {
    public static void main(String[] args) {
        //创建实现类对象
        MyInterImpl mi = new MyInterImpl();
        //使用接口中的同名静态常量  只能通过接口名调用
        //System.out.println(mi.NUM);
        System.out.println(MyInterA.NUM);
        System.out.println(MyInterB.NUM);
        //使用接口同名抽象方法
        mi.abstractMethod();
        //使用接口同名默认方法
        mi.defaultMethod();
        //使用接口同名静态方法
        MyInterA.staticMethod();
        MyInterB.staticMethod();
    }
}
