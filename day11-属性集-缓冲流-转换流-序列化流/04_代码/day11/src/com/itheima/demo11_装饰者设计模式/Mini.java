package com.itheima.demo11_装饰者设计模式;

public class Mini implements Car{
    @Override
    public void run() {
        System.out.println("时速60迈");
    }

    @Override
    public void stop() {
        System.out.println("可以正常停车");
    }
}
