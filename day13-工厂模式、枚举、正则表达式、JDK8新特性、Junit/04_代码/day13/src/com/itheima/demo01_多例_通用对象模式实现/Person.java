package com.itheima.demo01_多例_通用对象模式实现;

import java.util.ArrayList;
import java.util.Random;

/*
    多例设计模式：保证使用该类时，在程序运行期间，有且仅有固定个数的对象产生 从而节省内存空间
    实现步骤:
        1. 创建一个类,  将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
        2. 内部成员位置定义该类被创建的总数量,使用private static final修饰
        3. 内部成员位置定义一个“集合”,使用 private static修饰
        4. 在静态代码块中创建指定个数的本类对象,并添加到集合中
        5. 提供一个公有、静态方法，随机获取集合中的一个对象。

 */
public class Person {

    //1.将构造方法私有化，防止外部通过new无休止的创建该类的对象
    private Person(){}

    //2.在类的成员位置定义要创建的对象个数变量，使用private static final修饰这个变量
    //小写转大写 快捷键：ctrl+shift+u
    private static final int COUNT =3;

    //2.在类的成员位置定义一个集合，用来存储创建指定个数的对象  这个集合需要使用private static
    private static ArrayList<Person> list = new ArrayList<>();

    //3.静态代码块中创建固定个数对象【只在类加载时执行一次】，放入到集合中
    static{
        //使用循环创建指定个数对象
        for (int i = 0; i < COUNT; i++) {
            Person person = new Person();
            //添加到集合中
            list.add(person);
        }
    }

    //4.提供公共静态方法，随机从集合中返回一个对象出去
    public static Person getInstance(){
        //4.1:创建随机生成器对象 生成一个随机数【集合元素下标】
        Random random = new Random();
        int index = random.nextInt(COUNT); //[0,3)

        //4.2：根据生成的随机数 返回集合中某个对象元素
        return list.get(index);
    }

}

