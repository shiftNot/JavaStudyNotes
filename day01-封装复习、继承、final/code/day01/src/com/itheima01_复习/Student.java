package com.itheima01_复习;

public class Student {
    //成员变量
    private String name;
    private int age;

    //(Fn)+Alt+insert
    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show() {
        System.out.println(name + "," + age);
    }

    //内部类(后面学)
    class Inner {

    }

    //代码块(后面学)
    {

    }
}
