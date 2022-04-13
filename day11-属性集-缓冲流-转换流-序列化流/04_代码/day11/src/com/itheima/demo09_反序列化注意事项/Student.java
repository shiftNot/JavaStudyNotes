package com.itheima.demo09_反序列化注意事项;

import java.io.Serializable;

public class Student implements Serializable {
    static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private String sex;
    private String address;  //序列化后改变class文件

    public Student() {
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
