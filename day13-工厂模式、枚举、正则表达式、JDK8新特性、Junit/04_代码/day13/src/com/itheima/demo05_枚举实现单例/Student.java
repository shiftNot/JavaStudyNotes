package com.itheima.demo05_枚举实现单例;
/*
    单例设计模式一般用于工具类，让工具类【没有定义属性的类，只定义一些工具方法】在程序运行期间有且仅有一个对象，
        使用时调用方法getInstance获取到该类对象，再调用工具方法就可以完成指定的操作了
 */
public enum Student {
    STU;

    //测试创建枚举对象时机
    /*private Student(){
        System.out.println("无参构造方法执行...");
    }*/

    public void doSomething(){
        System.out.println("写你的业务逻辑代码....");
    }
}
