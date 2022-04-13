package com.itheima.demo10_序列化练习;

import java.io.*;
import java.util.ArrayList;

public class Test01 {
    public static void main(String[] args) throws Exception {
        /*
        需求
            1. 将存有多个学生对象的集合序列化操作，保存到list.txt文件中。
            2. 反序列化list.txt ，并遍历集合，打印对象信息。

            分析：
                1.创建多个学生对象存入list集合
                2.使用序列化流将list集合写入list.txt文件中
                3.使用反序列流将list.txt 学生对象集合字节数据重构为List集合对象
                4.遍历集合
         */
        //1.创建多个学生对象存入list集合
        Student stu1 = new Student("张三", 18);
        Student stu2 = new Student("李四", 28);
        Student stu3 = new Student("王五", 38);

        ArrayList<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        //2.使用序列化流将list集合写入list.txt文件中
        FileOutputStream fos = new FileOutputStream("day11\\dd\\list.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();

        //3.使用反序列流将list.txt 学生对象集合字节数据重构为List集合对象
        FileInputStream fis = new FileInputStream("day11\\dd\\list.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Student> list2 = (ArrayList<Student>) ois.readObject();
        ois.close();

        //4.遍历集合
        for (Student student : list2) {
            System.out.println("student = " + student);
        }

    }
}
