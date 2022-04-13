package com.itheima03_Map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/*
1.概述
	java.util.LinkedHashMap 是HashMap的一个子类，存储数据采用的哈希表结构(数组+双向链表+红黑树)。
	键值对的存储由键决定。若自定义类对象作为键,要确保键值对唯一,需重写hashCode和equals方法,原理同LinkedHashSet。
2.特点
	元素无索引,元素存取有序,元素不可重复(唯一)

需求:将包含姓名和年龄的学生对象作为键, 家庭住址作为值，存储到 LinkedHashmap集合中。

 */
public class Test_05LinkedHashMap键列存储自定义类型 {
    public static void main(String[] args) {
        //创建集合对象
        LinkedHashMap<StudentToHashMap, String> lhm = new LinkedHashMap<>();
        //创建学生对象
        StudentToHashMap s1 = new StudentToHashMap("张三", 18);
        StudentToHashMap s2 = new StudentToHashMap("李四", 20);
        StudentToHashMap s3 = new StudentToHashMap("王五", 22);
        StudentToHashMap s4 = new StudentToHashMap("张三", 18);
        //添加学生对象
        lhm.put(s1, "北京");
        lhm.put(s2, "上海");
        lhm.put(s3, "广州");
        lhm.put(s4, "深圳");
        //遍历
        Set<Map.Entry<StudentToHashMap, String>> entries = lhm.entrySet();
        for (Map.Entry<StudentToHashMap, String> entry : entries) {
            StudentToHashMap s = entry.getKey();
            String address = entry.getValue();
            System.out.println(s.name + "===" + s.age + "===" + address);
        }
    }
}
