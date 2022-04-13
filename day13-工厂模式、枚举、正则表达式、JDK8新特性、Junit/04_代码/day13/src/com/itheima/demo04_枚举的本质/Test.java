package com.itheima.demo04_枚举的本质;


enum Sex{
    MAN,
    WOMAN,
    YAO(110);
    //成员变量
    int num;

    //构造方法
    private Sex(){}

    private Sex(int num){
        this.num = num;
    }

    //成员方法
    public void method(){
        System.out.println("method ... num = "+num);
    }

}

/**
 枚举的本质
    1.枚举的本质就是一个使用了多例设计模式的类，同样可以拥有类中其他成员内容(构造方法、成员方法等)。
    2.枚举的值 就是该类的对象  就可以通过对象【枚举值】调用成员方法

 */
public class Test {
    public static void main(String[] args) {
        //1.获取枚举值  获取了一个对象
        Sex sex = Sex.MAN;

        //2.使用对象定义成员变量赋值
        sex.num = 200;

        //3.使用对象调用成员方法
        sex.method();
        Sex.YAO.method();
    }
}
