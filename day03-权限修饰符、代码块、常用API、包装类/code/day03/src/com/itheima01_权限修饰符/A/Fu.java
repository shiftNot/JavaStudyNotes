package com.itheima01_权限修饰符.A;

public class Fu {
    //公共的权限   任意范围
    public int pubNum = 10;
    //受保护的权限  在同一个包 或  不同包的子类
    protected int proNum = 10;
    //默认权限 只能在同一个包直接使用
    int num = 10;
    //私有权限  只能在本类中直接使用
    private int priNum = 10;


    //同一个类中，四种权限的访问
    public void show() {
        System.out.println("同一个类中的public权限" + pubNum);
        System.out.println("同一个类中的protected权限" + proNum);
        System.out.println("同一个类中的默认权限" + num);
        System.out.println("同一个类中的private权限" + priNum);
    }
}
