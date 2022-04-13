package com.itheima.demo13_收集Stream流结果到数组或集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        //收集Stream流结果到数组中
        /*
            Object[] toArray()  ：将流中元素收集到一个数组中
         */
        List<String> list1 = new ArrayList<>();
        list1.add("张三");
        list1.add("张三丰");
        list1.add("法外狂徒张三");
        list1.add("刘亦菲");
        list1.add("张曼玉");
        list1.add("张无忌");

        //需求：收集姓张的同学姓名存入到数组中
        Object[] objects = list1.stream().filter(name -> name.startsWith("张")).toArray();
        System.out.println("objects = " + Arrays.toString(objects));
    }
}
