package com.itheima03_Map;

public class StudentToTreeMap1 implements Comparable<StudentToTreeMap1> {
    String name;
    int age;

    public StudentToTreeMap1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentToTreeMap1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(StudentToTreeMap1 o) {//this   o
        //升序this vs  o
        //降序o  vs  this
        //需求:优先按照姓名的升序排列，如果姓名相同，按照年龄的降序排列
        int num = this.name.compareTo(o.name);
        num = (num == 0) ? o.age - this.age : num;
        return num;
    }
}
