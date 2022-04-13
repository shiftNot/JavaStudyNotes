package com.itheima01_权限修饰符.B;

import com.itheima01_权限修饰符.A.Fu;

public class ZiB extends Fu {
    //不同包下子类中，四种权限的访问
    public void show() {
        System.out.println("不同包的子类中的public权限" + pubNum);
        System.out.println("不同包的子类中的protected权限" + proNum);
        //System.out.println("不同包的子类中的默认权限" + num);
        //System.out.println("不同包的子类中的private权限" + priNum);
    }
}
