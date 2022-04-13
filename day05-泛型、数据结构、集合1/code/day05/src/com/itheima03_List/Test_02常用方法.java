package com.itheima03_List;

import java.util.ArrayList;
import java.util.List;

/*

常用方法
	public void add(int index, E element): 将指定的元素，添加到该集合中的指定位置上
	public E get(int index):返回集合中指定位置的元素
	public E remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素
	public E set(int index, E element):用指定元素替换集合中指定位置的元素,返回修改前的元素

需求:通过ArrayList类演示常用方法

 */
public class Test_02常用方法 {
    public static void main(String[] args) {
        //创建对象
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("原数据:" + list);


        //public void add(int index, E element): 将指定的元素，添加到该集合中的指定位置上
        list.add(1, "d");
        System.out.println("add-index:" + list);

        //public E get(int index):返回集合中指定位置的元素
        /*System.out.println("get:"+list.get(0));
        System.out.println("get:"+list.get(1));
        System.out.println("get:"+list.get(2));
        System.out.println("get:"+list.get(3));*/
        for (int i = 0; i < list.size(); i++) {
            System.out.println("get-index:" + list.get(i));
        }

        //public E remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素
        //System.out.println("remove：" + list.remove(1));//一般不用
        list.remove(1);
        System.out.println("remove-index：" + list);

        //public E set(int index, E element):用指定元素替换集合中指定位置的元素,返回修改前的元素
        //System.out.println(list.set(1, "d"));
        list.set(1, "d");
        System.out.println("set-index：" + list);
    }
}
