package com.itheima01_Generic;

public interface GenericInter<BSJ> {
    //作为形参
    public abstract void method(BSJ bsj);

    //作为返回值类型
    public abstract BSJ method2();
}
