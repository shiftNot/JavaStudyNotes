package com.itheima.demo07_方法引用;

public class Person {
    String name;

    public Person() {
    }
    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
