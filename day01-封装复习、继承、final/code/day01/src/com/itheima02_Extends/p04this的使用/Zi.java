package com.itheima02_Extends.p04this的使用;

public class Zi extends Fu {
    int num = 666;

    public Zi() {
        //this();//自己调用自己，如果能执行，意味着会出现死循环
        this(10);//必须在第一行。
        //super();//如果使用this调用本类构造方法，当前构造方法默认调用父类无参构造的操作将不存在，
        System.out.println("子类的无参构造方法");
    }

    public Zi(int num) {
        //super();
        System.out.println("子类的有参构造方法");
    }

    @Override
    public void method() {
        System.out.println("子类重写了父类的method方法");
    }

    public void show() {
        int num = 999;
        System.out.println("访问局部num变量:" + num);
        //this访问本类中的变量
        System.out.println("访问本类num变量:" + this.num);
        //this访问本类中的方法
        this.method();
        method();//不加this，也就按照就近原则,优先使用子类自己的方法。
    }
}
