package com.itheima.demo06_Lambda表达式使用;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        /*
        使用前提
            必须具有接口，且要求接口中有且仅有一个抽象方法。
            有且仅有一个抽象方法的接口，称为函数式接口
            @FunctionalInterface注解:检查一个接口是否是函数式接口
        格式:(参数类型 参数名)->{代码语句}
            ()内的语法与接口中抽象方法参数列表一致:无参数则留空，多个参数则用逗号分隔。
            ->是新引入的语法格式，代表指向动作。
            {}其实就是接口中抽象方法的实现代码(方法体)。
        应用方式
            方式1“无参、无返回值”
            方式2“有参、有返回值”
       使用套路：
            1.判断当前接口是否是函数式接口  【判断接口中是否只有一个抽象方法，或者接口上含有@FunctionalInterface注解】
            2.如果是函数式接口，就可以使用lambda表达式，格式：()->{}\
            3.填充小括号中的内容--->与接口中抽象方法参数保持一致（参数类型、个数、顺序）参数名称可以不一样
            4.填充大括号中的内容-->就是接口抽象方法的实现代码【方法体】
      */
        //需求:通过Lambda的标准格式完成Collections中的自定义排序功能与Runnable接口的使用。
        //案例一：使用lambda表达式创建Thread对象  使用Runnable接口 在Runnable接口中只有一个抽象方法void run() 方法没有参数和返回值
        //无参无返回值
        //new Thread(()->{ System.out.println("线程任务代码1...");}).start();

        //案例二：通过Lambda的标准格式完成Collections中的自定义排序功能
        //分析 ：Collections.sort(Comparator comparator);排序  Comparator是一个接口
        /*
            1.一个函数式接口有且只有一个抽象方法。
            2.默认方法不是抽象方法，因为它们已经实现了。
            3.重写了超类Object类中任意一个public方法的方法并不算接口中的抽象方法
            所以虽然Comparator接口中有两个抽象方法compare和equals，但equals并不算入接口中的抽象方法，所以Comparator接口还是满足函数式接口的要求，Comparator接口是一个函数式接口。
         */
        ArrayList<Integer> list = new ArrayList<>();
        list.add(500);
        list.add(300);
        list.add(400);
        list.add(200);
        list.add(100);
        System.out.println("排序前："+list);

        //方式一：使用原来的方式进行降序排列
        /*Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //前减后：升序
                //后减前：降序
                return o2-o1;
            }
        });*/


        //方式二：使用Lambda表达式 ，由于Comparator接口是一个函数式接口 就可以使用lambda表达式 简化代码编写
        //有参 有返回值
        Collections.sort(list,(Integer o1,Integer o2)->{return o2-o1;});

        System.out.println("排序后："+list);
        System.out.println("---------------------------------------------");

    }
}
