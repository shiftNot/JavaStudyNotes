package com.itheima.demo11_Stream常用方法;

import java.util.stream.Stream;

public class Test05_concat {
    public static void main(String[] args) {
        /*
            static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)  :合并两个流中的元素
         */
        Integer[] arr = {100,200,300};
        Stream<Integer> stream1 = Stream.of(arr);
        Stream<String> stream2 = Stream.of("张三", "李四", "王五", "赵六","田七");

        //把两个流中的元素合并到一个流中
        Stream.concat(stream1,stream2).forEach(name-> System.out.println(name));
    }
}
