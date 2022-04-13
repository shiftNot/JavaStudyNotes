package com.itheima.demo12_stream流案例练习;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        /*
        需求:使用Stream流实现如下需求

         */
        //定义两个ArrayList集合，代表两个队伍，存储多个姓名，依次进行以下操作
        List<String> list1 = new ArrayList<>();
        list1.add("张三");
        list1.add("张三丰");
        list1.add("法外狂徒张三");
        list1.add("刘亦菲");
        list1.add("张曼玉");
        list1.add("张无忌");

        List<String> list2 = new ArrayList<>();
        list2.add("白百何");
        list2.add("刘亦菲");
        list2.add("张小凡");
        list2.add("张帆帆");
        list2.add("迪丽热巴");
        list2.add("张柏芝");

        //第一个队伍只要名字为3个字的成员姓名；
        Stream<String> stream1 = list1.stream().filter(name -> name.length() == 3);

        //第一个队伍筛选之后只要前2个人；
        Stream<String> stream2 = stream1.limit(2);

        //第二个队伍只要姓张的成员姓名；
        Stream<String> stream3 = list2.stream().filter(name -> name.startsWith("张"));

        //第二个队伍筛选之后不要前2个人；
        Stream<String> stream4 = stream3.skip(2);


        //将两个队伍合并为一个队伍；
        Stream<String> allStream = Stream.concat(stream2, stream4);

        //根据姓名转换为Person对象；
        //打印整个队伍的Person对象信息。
        allStream.map(name->new Person(name)).forEach(person-> System.out.println(person));

        //问题：对集合使用Stream流筛选之后遍历输出 ，如果我第二次还想使用之前筛选的结果 就需要 重新使用Stream流操作一次
        //     及其不方便 筛选的结果不能进行后续使用
        //解决：可以对集合使用Stream流筛选后的结果存入到一个集合中【收集到一个集合中】  这样后续就可以继续使用筛选后的结果了


    }
}
