package com.itheima05_自定义类型应用.p02作为成员变量类型;

/*
需求:根据如下定义一个英雄类
    英雄类
    属性：姓名，武器，法术
    行为：展示英雄

 */
public class Test {
    public static void main(String[] args) {
        //创建武器对象
        Weapon w = new Weapon("方天画戟");
        //创建法术对象
        Magic m = new Magic("天崩地裂");
        //创建英雄对象
        Hero h = new Hero("皇子", w, m);
        h.show();
    }

}
