package com.itheima03_多态.p02多态时访问特点;

/*
多态时访问特点
    访问格式:
        对象名.成员变量名;
        对象名.方法名();
    访问特点
        成员变量:编译看左边,运行看左边  (编译时看父类,运行时找父类)
        成员方法:编译看左边,运行看右边  (编译时看父类,运行时找子类)
        静态方法:编译看左边,运行看左边  (编译时看父类,运行时找父类)
 */
public class Test {
    public static void main(String[] args) {
        //定义多态
        Fu f = new Zi();
        //左边(父类):等于号左边的类  右边(子类):等于号右边对象的类
        //成员变量
        System.out.println(f.num);//运行使用的是父类的该变量
        //System.out.println(f.num2);//多态场景下，编译变量看父类，父类没有num2,所以报错

        //成员方法
        f.method();//运行使用的是子类的该成员方法
        //f.method2();//多态场景下，编译成员方法看父类，父类没有method2,所以报错

        //静态方法
        f.staticMethod();//运行使用的是父类的该静态方法
        //f.staticMethod2();//多态场景下，编译静态方法看父类，父类没有staticMethod2,所以报错
    }
}

