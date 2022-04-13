package com.itheima.demo11_Stream常用方法;

import java.util.stream.Stream;

public class Test02_filter {
    /*
        Stream<T> filter(Predicate<? super T> predicate) :过滤流中的元素
            filter方法需要一个参数：Predicate类型  是一个函数式接口，判断接口
                 boolean test(T t)：参数就是流中每一个元素  满足条件返回true 可以继续向下流 不满足返回false
     */
    public static void main(String[] args) {
        //1.定义一个数组
        String[] arr = {"张三","李四","王五","张三丰"};
        //2.获取数组的流对象
        Stream<String> stream = Stream.of(arr);
        //3.需求：筛选姓张的同学并输出打印
        //stream.filter((String name)->{return name.startsWith("张");}).forEach((String name)->{System.out.println(name);});
        stream.filter(name -> name.startsWith("张")).forEach(name->System.out.println(name));
    }
}
