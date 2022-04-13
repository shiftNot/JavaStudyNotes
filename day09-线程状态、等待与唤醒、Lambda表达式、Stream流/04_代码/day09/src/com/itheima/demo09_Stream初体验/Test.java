package com.itheima.demo09_Stream初体验;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        /*
            需求:使用集合和Stream流中的方法完成下列需求
                定义一个集合，存储若干姓名
                将List集合中姓张的的元素过滤到一个新的集合中
                然后将过滤出来的姓张的元素中过滤出长度为3的元素,存储到一个新的集合中
         */
        //定义一个集合
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("张三丰");
        list.add("法外狂徒张三");
        list.add("刘亦菲");
        list.add("张曼玉");
        list.add("张无忌");

        //方式一：传统方式
        //1.将集合中姓张的同学存入list1集合中
        ArrayList<String> list1 = new ArrayList<>();
        for (String name : list) {
            if(name.startsWith("张")){
                list1.add(name);
            }
        }

        //2.将list1集合中姓张的同学 并且名字是三个字的存入list2集合中
        ArrayList<String> list2 = new ArrayList<>();
        for (String name : list1) {
            if(name.length()==3){
                list2.add(name);
            }
        }

        //打印筛选之后的结果  |  也可以遍历输出
        System.out.println("list2 = " + list2);

        System.out.println("------------------------------------------");
        //方式二：Stream流的方式
        list.stream()
                .filter((String name)->{return name.startsWith("张");})
                .filter((String name)->{return name.length()==3;})
                .forEach((String name)->{System.out.println(name);});


        System.out.println("------------------------------------------");
        //Stream流注意事项演示
        /*
            1.Stream流是一次性的 不能重复使用
            2.Stream流不会存储数据
            3.Stream流不会修改数据源
            4.Stream搭建的函数模型，只有终结方法存在，前面的延迟方法才会执行
                终结方法：Stream流中返回值类型不是Stream的方法
                延迟方法：Stream流中返回值类型依然是Stream的方法  表示可以继续进行Stream流操作
         */
        Stream<String> stream = list.stream();
        /*stream.filter((String name)->{ System.out.println("第一次筛选");return name.startsWith("张");})
                .filter((String name)->{System.out.println("第二次筛选");return name.length()==3;})
                .forEach((String name)->{System.out.println(name);});*/

        //System.out.println("list = " + list);

        //stream01 、stream02 都是属于同一个流式函数模型 只有终结方法存在 才会执行延迟方法
        Stream<String> stream01 = stream.filter((String name) -> {
            System.out.println("第一次筛选");
            return name.startsWith("张");
        });
        Stream<String> strem02 = stream01.filter((String name)->{System.out.println("第二次筛选");return name.length()==3;});

        strem02.forEach((String name)->{System.out.println(name);});

    }
}
