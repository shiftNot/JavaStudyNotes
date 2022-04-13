package com.itheima.demo10_获取流对象;

import java.util.stream.Stream;

public class Test02_获取数组流对象 {
    public static void main(String[] args) {
        //1.定义一个数组
        String[] arr = {"张三","李四","王五","赵六"};

        //2.获取数组流对象 使用Stream的静态方法of
        //方式一：直接传一个数组进行
        Stream<String> stream1 = Stream.of(arr);

        //方式二：直接传递数组元素 是一个可变参数
        Stream<String> stream2 = Stream.of("张三", "李四", "王五");


    }
}
