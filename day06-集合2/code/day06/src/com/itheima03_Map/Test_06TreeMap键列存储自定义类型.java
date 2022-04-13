package com.itheima03_Map;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
1.概述
	TreeMap集合是Map接口的一个实现类，底层依赖于TreeMap,是一种基于红黑树的实现
	TreeMap集合存储的对象作为键列,必须拥有排序规则(比较器)，否则会报出异常。
2.特点
	元素无索引,元素存取无序,元素不可重复(唯一)
3.使用方式
	自然排序:描述事物的类实现 java.lang.Comparable接口，重写compareTo方法，使用TreeMap无参构造创建集合对象
	比较器排序：创建重写compare方法的Comparator接口实现类对象，作为参数传入TreeMap的构造方法。

需求:将包含姓名和年龄的学生对象作为键, 家庭住址作为值，存储到 TreeMap集合中

 */
public class Test_06TreeMap键列存储自定义类型 {
    public static void main(String[] args) {
        //创建集合对象
        TreeMap<StudentToTreeMap1, String> tm = new TreeMap<>();
        //创建学生对象
        StudentToTreeMap1 s1 = new StudentToTreeMap1("zhangsan", 18);
        StudentToTreeMap1 s2 = new StudentToTreeMap1("lisi", 20);
        StudentToTreeMap1 s3 = new StudentToTreeMap1("wangwu", 22);
        StudentToTreeMap1 s4 = new StudentToTreeMap1("zhangsan", 18);
        StudentToTreeMap1 s5 = new StudentToTreeMap1("zhangsan", 20);
        //添加学生对象
        tm.put(s1, "北京");
        tm.put(s2, "上海");
        tm.put(s3, "广州");
        tm.put(s4, "深圳");
        tm.put(s5, "深圳");
        //遍历
        Set<StudentToTreeMap1> stus = tm.keySet();
        for (StudentToTreeMap1 s : stus) {
            String address = tm.get(s);
            System.out.println(s.name + "===" + s.age + "===" + address);
        }
        System.out.println("--------");
        //创建集合对象
        TreeMap<StudentToTreeMap2, String> tm2 = new TreeMap<>(new Comparator<StudentToTreeMap2>() {
            @Override
            public int compare(StudentToTreeMap2 o1, StudentToTreeMap2 o2) {
                //升序:o1 vs o2
                //降序:o2 vs o1
                //需求:优先按照姓名的升序排列，如果姓名相同，按照年龄的降序排列
                int num = o1.name.compareTo(o2.name);
                num = (num == 0) ? o2.age - o1.age : num;
                return num;
            }
        });
        //创建学生对象
        StudentToTreeMap2 st1 = new StudentToTreeMap2("zhangsan", 18);
        StudentToTreeMap2 st2 = new StudentToTreeMap2("lisi", 20);
        StudentToTreeMap2 st3 = new StudentToTreeMap2("wangwu", 22);
        StudentToTreeMap2 st4 = new StudentToTreeMap2("zhangsan", 18);
        StudentToTreeMap2 st5 = new StudentToTreeMap2("zhangsan", 20);
        //添加学生对象
        tm2.put(st1, "北京");
        tm2.put(st2, "上海");
        tm2.put(st3, "广州");
        tm2.put(st4, "深圳");
        tm2.put(st5, "深圳");
        //遍历
        Set<Map.Entry<StudentToTreeMap2, String>> entries = tm2.entrySet();
        for (Map.Entry<StudentToTreeMap2, String> entry : entries) {
            StudentToTreeMap2 s = entry.getKey();
            String address = entry.getValue();
            System.out.println(s.name + "===" + s.age + "===" + address);
        }
    }
}
