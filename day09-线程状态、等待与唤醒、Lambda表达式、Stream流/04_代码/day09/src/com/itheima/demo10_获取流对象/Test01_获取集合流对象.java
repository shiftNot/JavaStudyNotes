package com.itheima.demo10_获取流对象;

import java.util.*;
import java.util.stream.Stream;

public class Test01_获取集合流对象 {
    public static void main(String[] args) {
        /*
            1.由于Collection接口提供的默认的实现方法stream方法，单列集合可以直接调用stream方法获取流对象
            2.HashMap双列集合  可以分别获取键和值的集合流对象  也可以获取每一个map集合元素封装的entry的set集合 流对象

         */
        //1.获取list集合流对象
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("张三丰");
        list.add("法外狂徒张三");
        list.add("刘亦菲");
        list.add("张曼玉");
        list.add("张无忌");
        Stream<String> stream1 = list.stream();

        //2.获取set集合流对象
        HashSet<String> set = new HashSet<>();
        set.add("张三");
        set.add("张三丰");
        set.add("法外狂徒张三");
        set.add("刘亦菲");
        set.add("张曼玉");
        set.add("张无忌");
        Stream<String> stream2 = set.stream();

        //3.获取HashMap集合流对象
        HashMap<String,String> map = new HashMap<>();
        map.put("zs","张三");
        map.put("ls","李四");
        map.put("ww","王五");
        map.put("zl","赵六");

        //3.1：获取集合中所有的键的集合
        Set<String> keys = map.keySet();
        Stream<String> stream3 = keys.stream();

        //3.2:获取集合中所有值的集合
        Collection<String> values = map.values();
        Stream<String> stream4 = values.stream();

        //3.3:获取map集合中的键值对象的集合
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Stream<Map.Entry<String, String>> stream5 = entrySet.stream();
    }
}
