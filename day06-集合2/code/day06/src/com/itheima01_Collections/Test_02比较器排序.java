package com.itheima01_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
1.概述
	public interface Comparator<T>  定义比较对象规则的接口。
2.常用方法
	Comparator接口中提供了方法，如下
	public int compare(T  o1,T  o2) 比较用来排序的两个参数
	    o1表示后面的元素，o2表示前面的元素
3.应用场景
	用于Collections类的(自定义)排序功能，如下
	<T> void sort(List<T> list，Comparator<? super T> c):将集合中元素按照指定规则排序。

需求:演示Comparator在集合工具类排序功能中的使用

 */
public class Test_02比较器排序 {
    public static void main(String[] args) {
        //创建集合
        List<Integer> list = new ArrayList<>();
        //添加数据
        list.add(5);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(2);

        //<T> void sort(List<T> list，Comparator<? super T> c):将集合中元素按照指定规则排序。
       /* Comparator c = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                //o1代表后面的数据   o2代表前面的数据
                System.out.println("o1:" + o1 + ",o2:" + o2);
                //升序:o1 vs o2
                //降序:o2 vs o1
                //最终，根据比较的数值结果，来决定两个元素的顺序。
                //分为三种情况。<0调换位置     ==0(顺序不变)      >0不变
                //return o1 - o2;
                return o2 - o1;
            }
        };
        Collections.sort(list, c);*/

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        System.out.println(list);
    }
}
