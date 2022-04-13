package com.itheima03_List;

import java.util.LinkedList;

//自己定义一个集合，模拟栈结构
public class MyStatck<E> {
    private LinkedList<E> list;

    public MyStatck() {
        list = new LinkedList<>();
    }

    public void add(E e) {
        list.push(e);
    }

    public E get() {
        return list.pop();
    }
}
