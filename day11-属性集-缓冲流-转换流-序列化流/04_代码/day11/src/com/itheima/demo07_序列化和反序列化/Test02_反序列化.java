package com.itheima.demo07_序列化和反序列化;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class Test02_反序列化 {
    public static void main(String[] args) throws Exception {
        /*
        概述
            ObjectInputStream类(反序列化流)，将使用ObjectOutputStream序列化的原始数据恢复为对象。
        构造方法
            public ObjectInputStream(InputStream in) ： 创建一个指定反序列化流对象，需要传入一个字节输入流对象。
        特有方法
            public final Object readObject () : 从指定的路径，读取一个对象的字节数据，并返回该对象。
         */

        //1.创建反序列流对象
        FileInputStream fis = new FileInputStream("day11\\dd\\student.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        //2.重构对象  读取文件中对象二进制数据还原为一个对象
        Object object = ois.readObject();
        //System.out.println("object = " + object);

        Student student = (Student) object;
        System.out.println("student = " + student);

        //3.关闭流
        ois.close();
    }
}
