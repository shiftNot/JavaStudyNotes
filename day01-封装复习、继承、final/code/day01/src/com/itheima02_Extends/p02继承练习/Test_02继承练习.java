package com.itheima02_Extends.p02继承练习;

/*
思路:
    1.根据已存在的类，抽取共同的属性和行为，定义出父类。
    2.定义子类，继承父类，并在子类中添加子类特有的内容。

需求:请使用继承定义以下类
    学生类
        属性:姓名,年龄
        行为:吃饭,睡觉
    老师类
        属性:姓名,年龄，薪水
        行为:吃饭,睡觉，教书
    班主任
        属性:姓名,年龄，薪水
        行为:吃饭,睡觉，管理
 */
public class Test_02继承练习 {
    public static void main(String[] args) {
        //创建学生对象并使用
        Student s = new Student();
        s.name = "张三";
        s.age = 18;
        System.out.println(s.name + "==" + s.age);
        s.eat();
        s.sleep();
        System.out.println("--------");
        //创建老师对象并使用
        Teacher t = new Teacher();
        t.name = "JLF";
        t.age = 30;
        t.salary=66666;
        System.out.println(t.name + "==" + t.age+ "==" + t.salary);
        t.eat();
        t.sleep();
        t.teach();
        System.out.println("--------");
        //创建班主任对象并使用
        BanZhuRen bzr = new BanZhuRen();
        bzr.name = "兰姐";
        bzr.age = 18;
        bzr.salary=88888;
        System.out.println(bzr.name + "==" + bzr.age+ "==" + bzr.salary);
        bzr.eat();
        bzr.sleep();
        bzr.manager();
    }
}
