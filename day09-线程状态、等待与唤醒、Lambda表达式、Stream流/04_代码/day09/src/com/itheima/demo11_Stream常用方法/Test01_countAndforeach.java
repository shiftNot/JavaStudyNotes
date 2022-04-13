package com.itheima.demo11_Stream常用方法;

import java.util.stream.Stream;

public class Test01_countAndforeach {
    public static void main(String[] args) {
        /*
            Stream流终结方法：
                long count() ：返回此流中的元素个数
                void forEach(Consumer<? super T> action) ：对此流的每个元素执行操作。
         */

        //1.定义一个数组
        String[] arr = {"张三","李四","王五"};
        //2.获取数组的流对象
        Stream<String> stream = Stream.of(arr);
        //3.1:统计流对象中元素个数
        /*long count = stream.count();
        System.out.println("count = " + count);*/

        //3.2:使用foreach对流中每个元素进行操作
        //stream.forEach((String t)->{System.out.println(t);});
        stream.forEach(t->System.out.println(t));
    }
}
