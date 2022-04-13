package com.itheima01_Generic;

public class GenericClass2 {
    //作为形参
    public <TSL> void method(TSL tsl) {
        System.out.println(tsl);
    }

    //作为返回值类型
    //注意:如果在形参的位置不使用泛型，就意味着，将来泛型的类型，不能动态的改变。
    public <TSL> TSL method2() {
        //这里如果不报错，TSL必须是String类型。
        TSL tsl = (TSL) "abc";
        return tsl;
    }
}
