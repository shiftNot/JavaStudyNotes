package com.itheima02_接口.p01接口入门;

public class MyInterImpl implements MyInter {
    //实现类是非抽象类，必须重写接口中的抽象方法
    @Override
    public void abstractMethod() {
        System.out.println("实现类实现了接口中的抽象方法");
    }

    //接口中的默认方法，实现类可以重写，也可以不重写。
    @Override
    public void defaultMethod2(){
        System.out.println("实现类重写了接口中的默认方法2");
    }
    //静态的方法，不存在继承的理解的。
    //静态的内容，自然也就没有重写的这种说法。
    /*@Override
    public static void staticMethod() {
        System.out.println("接口中的静态方法");
    }*/
}
