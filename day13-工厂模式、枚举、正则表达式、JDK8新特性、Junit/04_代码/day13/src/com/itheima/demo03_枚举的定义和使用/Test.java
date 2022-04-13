package com.itheima.demo03_枚举的定义和使用;

//一个java文件中可以定义多个类 但是java文件名必须和public修饰的类保持一致 在这个java文件中只能有一个public修饰的类
class Person{
    String name; //用户名
    Sex sex;  //性别

    public Person(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
    }
}

/*
    介绍：枚举即列举，本质是一个类，用于列举属于该事物有限分类。例如:性别，方向，季节等
    作用：可以用来描述只有固定个数的值的类型,例如性别类型,方向类型,季节类型。
    应用场景：swtich语句、方法参数。

 */
public class Test {

    public static void main(String[] args) {

        /*
        //A程序员
        Person p1 = new Person("张三", "男");
        //B程序员
        Person p2 = new Person("李四","man");
        //不规范：
        Person p3 = new Person("李四","shahsahs");
        //因为：性别的值只有两种 男【man】和女【woman】 是一个固定个数的值，所以我们此时可以使用枚举定义性别 枚举就是列举：列举出指定的值
        */

        //使用枚举约束性别  枚举使用格式：枚举名.枚举值
        //A程序员
        Person p1 = new Person("张三", Sex.MAN);
        //B程序员
        Person p2 = new Person("李四",Sex.WOMAN);

        //表示方向向上
        Direction direction = Direction.LEFT;
        System.out.println("direction = " + direction);

        //枚举可以使用在switch中
        switch (direction){
            case UP:
                System.out.println("上");
                break;
            case DOWN:
                System.out.println("下");
                break;
            case LEFT:
                System.out.println("左");
                break;
            case RIGHT:
                System.out.println("右");
                break;
        }
    }
}
