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
 */
public class Test04_引用有参成员方法 {
    public static void main(String[] args) {
        /*
            有参方法引用格式： 对象名::方法名
         */
        //1.获取Stream流
        Stream<String> stream = Stream.of("张三", "张三丰", "古力娜扎");

        //需求：将流中的元素转换为元素的字符串长度，然后打印输出
        //stream.map((String str)->{return str.length();}).forEach((Integer len)->{System.out.println(len);});

        //分析：forEach方法中传入的Lambda表达式大括号中的代码实际上就是调用PrintStream类对象(System.out)的有参成员方法println，所以就可以使用该有参成员方法引入进来替换lambda表达式
        //stream.map((String str)->{return str.length();}).forEach(System.out::println);
        //底层执行：Integer num --> System.out.println(？)

        //上面的操作全部都可以使用方法引用
        stream.map(String::length).forEach(System.out::println);
    }
}
