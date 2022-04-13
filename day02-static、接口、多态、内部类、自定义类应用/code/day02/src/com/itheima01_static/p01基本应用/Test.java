package com.itheima01_static.p01基本应用;

/*
static概述
    1.static是静态修饰符，表示静态的意思,可以修饰类中成员(成员方法、成员变量、代码块等)。
    2.编码流程:编写--编译--运行(加载--执行)
    3.static修饰的内容是与对象无关的，即可以不通过对象操作。

修饰成员位置的变量:
    1.介绍：static修饰成员变量，称为类变量或静态变量，被该类的对象所共享，可以被任意对象(或直接通过类名)修改。
    2.定义格式：修饰符 static 数据类型 变量名；
    3.使用格式：类名.类变量名；

修饰成员位置的方法:
    1.介绍：static修饰方法，称为类方法或静态方法。类方法可以且建议直接使用类名调用。
    2.定义格式：
            修饰符 static 返回值类型 方法名 (参数列表){
        	    // 执行语句
            }
    3.使用格式：类名.静态方法名(参数)；
    4.注意事项:
    	静态方法可以直接访问类变量和静态方法。
    	静态方法不能直接访问普通成员变量或成员方法。
    	成员方法可以直接访问静态变量或静态方法。
    	静态方法中，不能使用this关键字。
修饰代码块
    1.介绍：
	    static修饰代码块，称为静态代码块。
	    位于成员位置，随着类的加载而执行(无需调用)。优先于main和构造方法。
    2.定义格式：
        static {}
 */
public class Test {

    public Test() {
        System.out.println("Test无参构造方法");
    }

    static {
        System.out.println("我是一个静态代码块");
    }

    public static void main(String[] args) {
        System.out.println("我是一个main方法");
        //匿名對象
        new Test();
        new Test();
        //static修饰代码块的使用
        //无法手动调用，随着类的加载而执行

        //static修饰成员位置变量的使用
        //创建StaticDemo对象使用期num的值
        StaticDemo sd = new StaticDemo();
        StaticDemo sd2 = new StaticDemo();
        //静态内容，不推荐使用对象名使用。
        System.out.println(sd.num);
        System.out.println(sd2.num);
        sd.num = 999;
        System.out.println(sd.num);
        System.out.println(sd2.num);
        //推荐使用类名的方式调用静态的内容
        StaticDemo.num = 9999;
        System.out.println(sd.num);
        System.out.println(sd2.num);

        //static修饰的成员位置的方法的使用
        //静态内容，不推荐使用对象名使用。
        sd.staticMethod();
        //推荐使用类名的方式调用静态的方法
        StaticDemo.staticMethod();


    }
}

