package com.itheima.bean;

public class Teacher extends Person {
    public Teacher() {
    }

    public Teacher(String sid, String name, String birthday, int age, String sex) {
        super(sid, name, birthday, age, sex);
    }

    @Override
    public String descrip() {
        return "我是一名老师,我的工作是讲课";
    }
}
