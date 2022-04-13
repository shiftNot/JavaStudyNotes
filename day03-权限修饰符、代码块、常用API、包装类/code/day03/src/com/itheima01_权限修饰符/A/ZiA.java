package com.itheima01_权限修饰符.A;

public class ZiA extends Fu {


    //同一个包下子类中，四种权限的访问
    public void show() {
        System.out.println("同一个包的子类中的public权限" + pubNum);
        System.out.println("同一个包的子类中的protected权限" + proNum);
        System.out.println("同一个包的子类中的默认权限" + num);
        //System.out.println("同一个包的子类中的private权限" + priNum);
    }
}
