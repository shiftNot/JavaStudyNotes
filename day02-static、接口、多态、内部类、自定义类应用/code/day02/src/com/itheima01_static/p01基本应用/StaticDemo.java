package com.itheima01_static.p01基本应用;

public class StaticDemo {
    //类变量
    static int num = 10;
    int num2 = 20;

    //类方法
    public static void staticMethod() {
        System.out.println("我是一个静态方法");
    }

    public static void staticShow() {
        //静态方法可以直接访问类变量和静态方法
        staticMethod();
        System.out.println(num);

        //静态方法不能"直接"访问普通成员变量或成员方法
        //如果想要使用，可以通过当前类的对象，去调用这些内容
        //为什么不能直接使用？
        //由于静态的内容，不需要创建对象使用的。而非静态的内容必须先有对象，才能使用
        //而当前的方法是一个静态方法，如果直接使用非静态内容，无法保证对象已经存在。
        //简单理解:静态的内容优先与非静态的内容存在。
        //method();
        //System.out.println(num2);

        //静态方法中，不能使用this关键字
        //this代表调用当前方法的对象  但是静态方法可以不通过对象来调用
        //所以，在静态的方法中是没有this的。
        //System.out.println(this.num2);
    }

    public void method() {

    }

    public void show() {
        //成员方法可以直接访问类变量或静态方法
        //字节码文件的加载优先与创建对象的过程
        //静态的内容优先与非静态的内容存在。
        staticMethod();
        System.out.println(num);
    }

}
