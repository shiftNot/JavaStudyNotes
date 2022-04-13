package com.itheima04_final;

//成员变量被final修饰
public class Demo {
    //final int NUM;//被final修饰的成员变量，不识别默认值(希望自己明确指定该常量的值)。
    //final int NUM = 10;//直接给值
    //如果创建对象前，还没有想好该常量的值，可以交给构造方法
    //要保证所有的构造方法，在创建好对象的时候，该常量都需要明确的赋值。
    final int NUM;


    public Demo(){
        NUM=10;
    }

    public Demo(int num){
        NUM=num;
    }
}
