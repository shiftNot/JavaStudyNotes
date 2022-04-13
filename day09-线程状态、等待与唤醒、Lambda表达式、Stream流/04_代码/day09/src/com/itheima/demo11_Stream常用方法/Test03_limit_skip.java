package com.itheima.demo11_Stream常用方法;

import java.util.stream.Stream;

public class Test03_limit_skip {
    public static void main(String[] args) {
        /*
            Stream<T> limit(long maxSize) :取流对象中前n个元素【包含n】
            Stream<T> skip(long n)  :跳过对象中前n个元素【包含】 取剩下的元素
         */
        //1.定义一个数组
        String[] arr = {"张三","李四","王五","张三丰"};
        //2.获取数组的流对象
        Stream<String> stream = Stream.of(arr);
        //3.1 需求：使用limit去取流对象中前2个元素
        //stream.limit(2).forEach(name->System.out.println(name));没问题
        //stream.limit(4).forEach(name->System.out.println(name));没问题
        //stream.limit(5).forEach(name->System.out.println(name));没问题
        //stream.limit(-1).forEach(name->System.out.println(name));有问题

        //3.2 需求：使用skip取流对象中的元素 跳过前n个

        //stream.skip(2).forEach(name->System.out.println(name));//王五  张三丰
        //stream.skip(0).forEach(name->System.out.println(name));//张三 李四 王五  张三丰
        //stream.skip(5).forEach(name->System.out.println(name));//没问题
        stream.skip(-1).forEach(name->System.out.println(name));//有问题 报：IllegalArgumentException: -1


    }
}
