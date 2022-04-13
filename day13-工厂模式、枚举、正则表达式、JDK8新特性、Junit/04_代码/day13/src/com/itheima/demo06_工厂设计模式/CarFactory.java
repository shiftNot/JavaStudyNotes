package com.itheima.demo06_工厂设计模式;

public class CarFactory {

    public static Car createCar(String brand){
        if("falali".equals(brand)){
            //省略了若干为属性赋值的代码
            return new Falali();
        }else if ("benci".equals(brand)){
            return new Benci();
        }else if ("tesla".equals(brand)){
            return new Tesla();
        }else{
            return null;
        }
    }
}
