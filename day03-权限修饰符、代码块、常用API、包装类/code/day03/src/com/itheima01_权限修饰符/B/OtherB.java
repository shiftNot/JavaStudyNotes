package com.itheima01_权限修饰符.B;

import com.itheima01_权限修饰符.A.Fu;

public class OtherB {
    //不同包无关类中，四种权限的访问
    public void show() {
        Fu f = new Fu();
        System.out.println("不同包无关类的public权限" + f.pubNum);
        //System.out.println("不同包无关类的protected权限" + f.proNum);
        //System.out.println("不同包无关类的默认权限" + f.num);
        //System.out.println("不同包无关类的private权限" + f.priNum);
    }
}
