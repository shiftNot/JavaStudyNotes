package com.itheima02_Extends.p05super的使用;

public class Zi extends Fu {
    int num = 666;

    //需要同事对子类和父类中所有的变量，在创建对象的时候赋值。
    public Zi() {
    }

    public Zi(int fuNum, int ziNum) {
        //super.num=fuNum;
        //super();
        super(fuNum);//标准用法
        System.out.println("子类的有参构造方法");
        this.num = ziNum;
    }

    @Override
    public void method() {
        //重写的本质是对父类的方法增强(保留原有的，增加新的)，
        super.method();
        System.out.println("子类重写父类的method方法");
    }

    public void show() {
        int num = 999;
        System.out.println("访问局部num变量:" + num);
        System.out.println("访问本类num变量:" + this.num);
        System.out.println("访问父类num变量:" + super.num);

        this.method();//this可以不写，表示本类中的方法
        super.method();//表示父类中的方法

    }
}
