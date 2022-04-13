package com.itheima02_Set;

public class StudentToTreeSet1 implements Comparable<StudentToTreeSet1> {
    String name;
    int age;

    public StudentToTreeSet1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentToTreeSet1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(StudentToTreeSet1 s) {//this 当前方法的调用对象  s表示要对比的对象
        //System.out.println("this:" + this + "s:" + s);
        //this代表正在添加的数据  s代表之前已经添加的数据
        //升序:this vs s
        //降序:s vs this
        //需求:优先按照姓名升序，如果姓名相同，按照年龄降序
        /*int num = this.name.compareTo(s.name);
        int num2 = (num==0)?s.age-this.age:num;
        return num2;*/
        return (this.name.compareTo(s.name) == 0) ? s.age - this.age : this.name.compareTo(s.name);
    }
}
