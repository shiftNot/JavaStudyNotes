package com.itheima01_Generic;

public class GenericClass1<BYD> {
    //作为形参
    public void method(BYD byd) {
        System.out.println(byd);
    }

    //作为返回值类型
    public BYD method2() {
        //这里如果不报错，BYD必须是String类型。
        BYD byd = (BYD) "abc";
        return byd;
    }
}
