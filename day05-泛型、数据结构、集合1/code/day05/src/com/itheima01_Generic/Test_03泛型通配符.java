package com.itheima01_Generic;

import java.util.ArrayList;

/*
泛型通配符
    1.概述
    	泛型的使用不存在继承关系，不可以给已指定泛型的变量接收有其他泛型类型的对象。
    		例如:ArrayList<Object> list = new ArrayList<String>()//错误格式，泛型不存在继承关系
    	泛型通配符用问号(?)表示。用于限制泛型数据类型的定义区间。单独使用表示任意类型，与不写的效果相同。。
    2.使用格式
    	数据类型<?> 对象名;
    	对象名 = 带具体泛型类型的对象;
泛型受限
    1.概述:限制泛型数据类型的定义区间
    2.使用格式
        泛型的上限：接收泛型为该泛型数据类型或其子类的对象
            格式：数据类型 <? extends 泛型数据类型 > 对象名称
        泛型的下限：接收泛型为该泛型数据类型或其父类的对象
            格式： 数据类型 <? super 泛型数据类型 > 对象名称
泛型受限的应用
    1.概述:在开发中，对于有泛型限制的定义,通常将这样的变量作为参数，控制接受数据的泛型类型。
    2.应用形式
    	形式1：修饰符  返回值 方法名(类名<?> 变量名){}//单独使用，没有意义
    	形式2：修饰符  返回值 方法名(类名<? extends 数据类型>  变量名){}
    	形式3：修饰符  返回值 方法名(类名<? super 数据类型>  变量名){}
示例：定义父子孙三个类，在测试类中演示泛型受限的使用

 */
public class Test_03泛型通配符 {
    public static void main(String[] args) {
        //泛型不支持继承
        /*ArrayList<Object>  array ;
        array=new ArrayList<String>();*/
        //假设，现在有一个对象的泛型不知道是什么类型。
        //第一种办法:不定义泛型，泛型由将来的对象的泛型来确定 泛型被认为是Object类型。这是语法检查的问题。
        //而我们知道，如果泛型是以Object类型存在，并不好。可能会导致类型转换异常。
        /*ArrayList array;
        array = new ArrayList<String>();
        array.add("abc");
        array.add(100);*/

        //第二种：建议的方式 使用泛型通配符  ？
        ArrayList<?> array;
        ArrayList<String> array2 = new ArrayList<>();
        array2.add("abc");
        //array2.add(100);
        array = array2;

        //泛型通配符作用
        ArrayList<Ye> list1 = new ArrayList<>();
        ArrayList<Fu> list2 = new ArrayList<>();
        ArrayList<Zi> list3 = new ArrayList<>();
        //泛型的上限:？所代表的类型的最大类型的范围
        ArrayList<? extends Fu> lista;
        //lista=list1;
        lista = list2;
        lista = list3;
        //泛型的下限:？所代表的类型的最小类型的范围
        ArrayList<? super Fu> listb;
        listb = list1;
        listb = list2;
        //listb=list3;

        //泛型通配符的应用:作为形参
        //method(list1);
        method(list2);
        method(list3);
        method2(list1);
        method2(list2);
        //method2(list3);

    }

    //这个方法的参数，集合对象，只能接收泛型为Fu类或Zi类的集合对象
    public static void method(ArrayList<? extends Fu> list) {

    }

    //这个方法的参数，集合对象，只能接收泛型为YE类或Fu类的集合对象
    public static void method2(ArrayList<? super Fu> list) {

    }
}
