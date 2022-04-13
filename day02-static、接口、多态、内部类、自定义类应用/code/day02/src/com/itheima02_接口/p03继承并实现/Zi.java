package com.itheima02_接口.p03继承并实现;

public class Zi extends Fu implements MyInter {

    //重写同名的抽象方法 重写1次
    @Override
    public void abstractMethod() {
        System.out.println("重写了父类与接口同名的抽象方法");
    }

    //父类与接口中有同名的默认方法，优先使用父类中的该成员方法。

    //父类中的静态方法，子类不能继承的。不认为是一种继承，只是一种特殊的用法。
   /* @Override
    public static void staticMethod() {
        System.out.println("子类重写父类的静态放阿飞");
    }*/
}
