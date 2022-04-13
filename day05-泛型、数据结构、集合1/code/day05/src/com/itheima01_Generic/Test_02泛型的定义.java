package com.itheima01_Generic;

/*
含有泛型的类
    1.概述
    	泛型是数据类型的一部分，将类名与泛型合并一起看做数据类型，定义对象时，确定泛型类型。
    	类上添加泛型的使用，可以让在多处操作需要统一数据类型时的限制操作。
    2.定义格式
    	修饰符 public  class 类名<代表泛型的变量> {
    		//应用1:作为方法的参数
    		//应用2:作为方法的返回值类型
    	}
    3.使用格式
    	属性类型<泛型类型> 变量名  = new 数据类型<>();//常见使用
    	属性类型<泛型类型> 变量名  = new 数据类型<泛型类型>();
    	属性类型<泛型类型> 变量名  = new 数据类型();

含有泛型的方法
    1.概述 泛型接口约束实现类是含有泛型的类型，实现类要么保留泛型，要么指定泛型的具体类型。
    2.定义格式
    	修饰符 interface 接口名 <代表泛型的变量> { }
    3.使用格式
    	格式一:修饰符 public  class 类名 implements  接口名 <数据类型> { }
    	格式二:修饰符 public  class 类名<代表泛型的变量> implements  接口名 <代表泛型的变量> { }


含有泛型的接口
    1.概述 定义泛型的方法，泛型用于参数或返回值类型，效果类似参数为Object的使用，但避免了向下转型。
    2.定义格式
    	饰符  <代表泛型的变量> 返回值类型 方法名(代表泛型的变量  变量名...){  }
    3.使用格式
    	对象.方法名(实际参数);
案例：测试类中定义泛型，并使用。

 */
public class Test_02泛型的定义 {
    public static void main(String[] args) {
        //含有泛型的类的使用
        GenericClass1<String> gc1 = new GenericClass1<>();
        /*
        GenericClass1<String> gc2 = new GenericClass1<String>();
        GenericClass1<String> gc3 = new GenericClass1();*/

        gc1.method("abc");
        String s = gc1.method2();
        System.out.println(s);

        //含有泛型的方法的使用
        GenericClass2 gc2 = new GenericClass2();
        gc2.method("abc");
        Object o = gc2.method2();//如果泛型不指定类型，使用阶段，泛型会被认为是Object类型。
        System.out.println(o);

        //含有泛型的接口的使用
        GenericInterImpl1 gci1 = new GenericInterImpl1();
        gci1.method("abc");
        String s2 = gci1.method2();
        System.out.println(s2);
        GenericInterImpl2<String> gci2 = new GenericInterImpl2<>();
        gci2.method("abc");
        String s3 = gci2.method2();
        System.out.println(s3);
    }
}
