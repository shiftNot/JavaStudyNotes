package com.itheima.demo08_序列化注意事项;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private transient int age; //瞬态  忽略  在序列化Student对象的时候 不保存age属性字节数据到文件中
    private Address address;

    public Student() {
    }

    public Student(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
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
                ", address=" + address +
                '}';
    }
}
