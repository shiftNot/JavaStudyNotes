package com.itheima03_List;

import java.util.LinkedList;

/*
java.util.ArrayList 数组存储结构集合； 特点：查询快,增删慢,线程不安全
java.util.LinkedList链表存储结构集合； 特点：查询慢,增删快,线程不安全
LinkedList实现原理:双向链表
LinkedList集合特有方法(了解)
            public void addFirst(E e):将指定元素插入此列表的开头
            public void addLast(E e):将指定元素添加到此列表的结尾
            public E getFirst():返回此列表的第一个元素
            public E getLast():返回此列表的最后一个元素
            public E removeFirst():移除并返回此列表的第一个元素
            public E removeLast():移除并返回此列表的最后一个元素
            public E pop():从此列表所表示的堆栈处弹出一个元素
            public void push(E e):将元素推入此列表所表示的堆栈

需求:演示LinkedList类常用方法
 */
public class Test_03常用子类 {
    public static void main(String[] args) {
        //创建对象
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println("原数据:" + list);

        //public void addFirst(E e):将指定元素插入此列表的开头
        list.addFirst("a");
        System.out.println("addFirst:" + list);

        //public void addLast(E e):将指定元素添加到此列表的结尾
        list.addLast("b");
        System.out.println("addLast:" + list);

        //public E getFirst():返回此列表的第一个元素
        System.out.println("getFirst:" + list.getFirst());
        System.out.println("getFirst:" + list);

        //public E getLast():返回此列表的最后一个元素
        System.out.println("getLast:" + list.getLast());
        System.out.println("getLast:" + list);

        //public E removeFirst():移除并返回此列表的第一个元素
        System.out.println("removeFirst:" + list.removeFirst());
        System.out.println("removeFirst:" + list);

        //public E removeLast():移除并返回此列表的最后一个元素
        System.out.println("removeLast:" + list.removeLast());
        System.out.println("removeLast:" + list);

        //public E pop():从此列表所表示的堆栈处弹出一个元素
        System.out.println("pop:" + list.pop());
        System.out.println("pop:" + list);

        //public void push(E e):将元素推入此列表所表示的堆栈
        list.push("1");
        System.out.println("push:" + list);

    }
}
