package com.itheima.demo07_方法引用;

import java.util.stream.Stream;

/**
 方法引入：就是用来替代Lambda表达式，如果lambda表达式大括号中的代码已经有方法实现了，就可以使用方法引用
 方法引入使用套路：
     1.是否可以使用lambda表达式
     2.lambda表达式{}中的代码是不是已经有方法完成了 是就可以使用方法引用了
     3.判断要引入的方法类型 根据指定方法类型的引入格式进行引用 替代Lambda
         1.构造器方法：类名::new
         2.静态方法：   类名::方法名
         3.无参成员方法：  类名::方法名
         4.有参成员方法：  对象名::方法名
    注意细节：Lambda表达式大括号中的代码有方法实现，却不能使用方法引入
            不是所有的Lambda表达式都可以使用方法引用替代。

 */
public class Test05_方法引入注意细节 {
    public static void main(String[] args) {
        /*
            无参方法引用格式： 类名::方法名
         */
        //1.获取Stream流
        Stream<String> stream = Stream.of("张三", "张三丰", "古力娜扎");

        //需求：将流中的元素 筛选出姓张的，然后打印输出
        //stream.filter((String name)->{return name.startsWith("张");}).forEach(System.out::println);

        /*
            分析：
                1.在filter方法Lambda表达式大括号中代码实际上就是调用了String类对象的有参成员方法startsWith
                2.使用带参方法引用本质：对象名.方法名(方法参数)
                3.此时不能使用方法引入，因为对象和方法参数两个位置都是不确定的  方法引入不知道该把流中的元素作为对象名还是作为方法参数传入进来
       */
        //错误示例
        //stream.filter((String::startsWith}).forEach(System.out::println);

    }
}
