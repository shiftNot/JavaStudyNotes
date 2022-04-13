package com.itheima.demo11_Stream常用方法;

import java.util.stream.Stream;

public class Test04_map {
    public static void main(String[] args) {
        /*
            <R> Stream<R> map(Function<? super T,? extends R> mapper)  ：映射流中的元素【进行类型转换】
                R apply(T t); t就是流中的元素  R就是转换后的返回值类型
         */

        //1.获取流
        Stream<String> stream = Stream.of("100", "200", "300", "400");

        //2.将流中的每个元素转为int类型  使用map方法进行映射
        //stream.forEach(num->System.out.println(num+1));
        //stream.map(num->Integer.parseInt(num)).forEach(num->System.out.println(num+1));
        stream.map(num->"java"+num).forEach(num->System.out.println(num));

    }
}
