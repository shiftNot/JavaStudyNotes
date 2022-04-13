package com.itheima.bean;

public class Student extends Person {
    public Student() {
    }

    public Student(String sid, String name, String birthday, int age, String sex) {
        super(sid, name, birthday, age, sex);
    }

    @Override
    public String descrip() {
        return "我是一名学生,我的工作是学习";
    }
}
