package com.itheima02_Extends.p03访问规则;

public class Fu {
    private int num;
    int a = 0;
    int b1 = 111;

    public Fu() {
        System.out.println("我是父类的无参构造方法");
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void show() {
        System.out.println("父类中的show方法");
    }

    public void show1() {
        System.out.println("父类中的show1方法");
    }
}
