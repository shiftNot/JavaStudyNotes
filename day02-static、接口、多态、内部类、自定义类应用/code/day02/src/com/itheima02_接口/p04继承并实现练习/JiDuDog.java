package com.itheima02_接口.p04继承并实现练习;

public class JiDuDog extends Dog implements JiDuInter {
    @Override
    public void eat() {
        System.out.println("吃军粮");
    }

    @Override
    public void jiDu() {
        System.out.println("用鼻子搜索毒品");
    }
}
