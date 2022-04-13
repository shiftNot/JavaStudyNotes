package com.itheima.demo13_收集Stream流结果到数组或集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test02 {
    public static void main(String[] args) {
        //收集Stream流结果到集合中
        /*
               <R,A> R collect(Collector<? super T,A,R> collector)  ：将流中的元素收集到集合中
                    collect方法参数可以使用：
                        Collectors.toList:表示收集到list集合中
                        Collectors.toSet:表示收集到set集合中

         */
        List<String> list1 = new ArrayList<>();
        list1.add("张三");
        list1.add("张三丰");
        list1.add("法外狂徒张三");
        list1.add("刘亦菲");
        list1.add("张曼玉");
        list1.add("张无忌");
        list1.add("张三");

        //需求：收集姓张的同学姓名存入到集合中
        List<String> list = list1.stream().filter(name -> name.startsWith("张")).collect(Collectors.toList());
        System.out.println("list = " + list);

        Set<String> set = list1.stream().filter(name -> name.startsWith("张")).collect(Collectors.toSet());
        System.out.println("set = " + set);

        //扩展一下：
        String s = list1.stream().filter(name -> name.startsWith("张")).collect(Collectors.joining("-"));
        System.out.println("s = " + s);


    }
}
