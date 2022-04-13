package com.itheima03_多态.p04多态应用;

public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    //捉老鼠
    public void catchMouse() {
        System.out.println("抓老鼠");
    }
}
