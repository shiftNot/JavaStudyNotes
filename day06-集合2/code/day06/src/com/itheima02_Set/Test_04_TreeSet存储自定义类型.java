package com.itheima02_Set;

/*
1.概概述
	TreeSet集合是Set接口的一个实现类，底层依赖于TreeMap,是一种基于红黑树的实现
	TreeSet集合存储的对象必须拥有排序规则(比较器)，否则会报出异常。
2.特点：元素无索引,元素存取无序,元素不可重复(唯一)
3.使用方式
	自然排序:描述事物的类实现 java.lang.Comparable接口，重写compareTo(Object o)方法，使用TreeSet无参构造创建集合对象
	    this表示后添加的元素
	比较器排序：创建重写compare(E e1,E e2)方法的Comparator接口实现类对象，作为参数传入TreeSet的构造方法。
	    e1表示后添加的元素
 */

import java.util.Comparator;
import java.util.TreeSet;

public class Test_04_TreeSet存储自定义类型 {
    public static void main(String[] args) {
        //创建集合对象
        TreeSet<StudentToTreeSet1> ts = new TreeSet<>();
        //创建学生对象
        StudentToTreeSet1 s1 = new StudentToTreeSet1("zhangsan", 18);
        StudentToTreeSet1 s2 = new StudentToTreeSet1("lisi", 20);
        StudentToTreeSet1 s3 = new StudentToTreeSet1("wangwu", 22);
        StudentToTreeSet1 s4 = new StudentToTreeSet1("zhangsan", 18);
        StudentToTreeSet1 s5 = new StudentToTreeSet1("zhangsan", 20);
        //添加数据
        ts.add(s1);//StudentToTreeSet1 cannot be cast to Comparable
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        //遍历
        for (StudentToTreeSet1 s : ts) {
            System.out.println(s);
        }
        System.out.println("---------");
        //TreeSet有参构造方法
        //如果使用TreeSet有参构造传入Comparator实现类对象，被存储的对象，可以不用实现自然排序。
        TreeSet<StudentToTreeSet2> ts2 = new TreeSet<>(new Comparator<StudentToTreeSet2>() {
            @Override
            public int compare(StudentToTreeSet2 o1, StudentToTreeSet2 o2) {
                //o1代表正在添加的数据  o2代表之前已经添加的数据
                //升序:o1 vs o2
                //降序:o2 vs o1
                //需求:优先按照姓名升序，如果姓名相同，按照年龄降序
                int num = o1.name.compareTo(o2.name);
                int num2 = (num == 0) ? o2.age - o1.age : num;
                return num2;
                //自己尝试简化成一步完成
            }
        });
        //创建对象
        StudentToTreeSet2 st1 = new StudentToTreeSet2("zhangsan", 18);
        StudentToTreeSet2 st2 = new StudentToTreeSet2("lisi", 20);
        StudentToTreeSet2 st3 = new StudentToTreeSet2("wangwu", 22);
        StudentToTreeSet2 st4 = new StudentToTreeSet2("zhangsan", 18);
        StudentToTreeSet2 st5 = new StudentToTreeSet2("zhangsan", 20);
        //添加数据
        ts2.add(st1);
        ts2.add(st2);
        ts2.add(st3);
        ts2.add(st4);
        ts2.add(st5);
        //遍历
        for (StudentToTreeSet2 s : ts2) {
            System.out.println(s);
        }
    }
}
