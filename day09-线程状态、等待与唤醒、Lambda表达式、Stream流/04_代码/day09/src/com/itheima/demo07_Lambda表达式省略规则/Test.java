package com.itheima.demo07_Lambda表达式省略规则;

import java.util.ArrayList;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        /*
        省略规则：
            1.小括号内参数的类型可以省略；
            2.如果小括号内有且仅有一个参数，则小括号和参数类型可以一起省略；
            3.如果大括号内有且仅有一个语句，则可以同时省略一对大括号，语句后的分号，return关键字；
            注意：
                如果接口中的抽象方法没有参数，则小括号不能省略，需要写一个空的小括号()
         */

        //案例一：使用lambda表达式创建Thread对象  使用Runnable接口 在Runnable接口中只有一个抽象方法void run() 方法没有参数和返回值
        //无参无返回值
        new Thread(()->System.out.println("线程任务代码1...")).start();

        //案例二：通过Lambda的标准格式完成Collections中的自定义排序功能
        ArrayList<Integer> list = new ArrayList<>();
        list.add(500);
        list.add(300);
        list.add(400);
        list.add(200);
        list.add(100);
        System.out.println("排序前："+list);

        //方式二：使用Lambda表达式 ，由于Comparator接口是一个函数式接口 就可以使用lambda表达式 简化代码编写
        //有参 有返回值
        //Collections.sort(list,(Integer o1, Integer o2)->{return o2-o1;});
        //Collections.sort(list,(o1, o2)->{return o2-o1;});
        Collections.sort(list,(o1, o2) -> o2-o1);

        System.out.println("排序后："+list);
        System.out.println("---------------------------------------------");
    }
}
