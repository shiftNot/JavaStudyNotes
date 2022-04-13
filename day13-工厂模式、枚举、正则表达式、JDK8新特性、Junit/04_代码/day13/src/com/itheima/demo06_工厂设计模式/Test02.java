package com.itheima.demo06_工厂设计模式;

public class Test02 {
    public static void main(String[] args) {
        /*//需求：创建Falali对象 调用run方法
        Falali falali = new Falali();
        falali.run();

        //需求：创建Benci对象 调用run方法
        Benci benci = new Benci();
        benci.run();

        //需求：创建Tesla对象 调用run方法
        Tesla tesla = new Tesla();
        tesla.run();*/

        //需求：创建Falali对象 调用run方法
        Car falali = CarFactory.createCar("falali");
        falali.run();

        //需求：创建Benci对象 调用run方法
        Car benci = CarFactory.createCar("benci");
        benci.run();

        //需求：创建Tesla对象 调用run方法
        Car tesla = CarFactory.createCar("tesla");
        tesla.run();


    }
}
