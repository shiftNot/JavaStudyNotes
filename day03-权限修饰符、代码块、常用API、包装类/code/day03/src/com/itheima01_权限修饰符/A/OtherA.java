package com.itheima01_权限修饰符.A;

public class OtherA {

    //同一个包的无关类中，四种权限的访问
    public void show() {
        Fu f = new Fu();
        System.out.println("同一个包的无关类中的public权限" + f.pubNum);
        System.out.println("同一个包的无关类中的protected权限" + f.proNum);
        System.out.println("同一个包的无关类中的默认权限" + f.num);
        //System.out.println("同一个包的无关类中的private权限" + f.priNum);
    }
}
