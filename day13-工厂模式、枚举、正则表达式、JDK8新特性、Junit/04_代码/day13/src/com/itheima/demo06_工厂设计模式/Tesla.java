package com.itheima.demo06_工厂设计模式;

public class Tesla implements Car{
    //省略了若干属性
    @Override
    public void run(){
        System.out.println("特斯拉以200迈的速度行驶...");
    }
}
