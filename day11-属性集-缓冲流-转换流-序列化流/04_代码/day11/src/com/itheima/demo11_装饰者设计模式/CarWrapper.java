package com.itheima.demo11_装饰者设计模式;

public class CarWrapper implements Car{

    private Car car;

    public CarWrapper(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        System.out.println("经过改装");
        System.out.println("3s破百");
    }

    @Override
    public void stop() {
        car.stop();
    }
}
