package com.itheima.demo11_装饰者设计模式;

public class Test {

    /*
        //装饰者设计模式实现步骤：
            1.装饰类和被装饰类必须实现相同的接口
            2.在装饰类中必须传入被装饰类的引用
            3.在装饰类中对需要扩展的方法进行扩展
            4在装饰类中对不需要扩展的方法调用被装饰类中的同名方法
        解决的问题：就是实现 在不改变原类，不使用继承的基础上  对对象的功能进行增强扩展。


        需求：
        情况：小明想找一个女朋友，要买一辆车 经费有限只能买一辆五菱Mini，时速只有60迈 找不到女朋友
        现在：为了能够找到女朋友  小明痛下决心 将车开进改装店  改装之后3s破百
        车：
            行驶 run
            停止 stop
        现在：不让你修改原类 也不需要你使用继承  如何改装增强：
            1.定义一个车接口Car  run和stop
            2.定义一个Mini车类  实现Car接口 重写run和stop
            3.定义一个改装店类 CarWrapper实现Car接口
            4.将车开进改装店 进行改装  需要增强的进行扩展   不需要增强使用原有的
     */
    public static void main(String[] args) {
        //准备一台mini
        Mini mini = new Mini();
        System.out.println("没有改装之前===========：");
        mini.run();
        mini.stop();

        System.out.println("改装之后===============：");
        //准备一家改装店  把车开进改装店  得到改装后的车
        CarWrapper miniPlus = new CarWrapper(mini);
        miniPlus.run();
        miniPlus.stop();


    }
}
