package com.itheima.demo09_反序列化注意事项;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test01_序列化 {
    public static void main(String[] args) throws Exception {
        /*
            概述
            java.io.ObjectOutputStream 类(序列化流)，将Java对象的原始数据类型写出到文件,实现对象的持久存储。
            对象要想序列化，须满足两个条件:
                1.类实现java.io.Serializable标记接口，否则会抛出NotSerializableException。
                2.属性需要可序列化。如果某属性不想序列化，须注明瞬态transient 关键字修饰。
            构造方法
                3.public ObjectOutputStream(OutputStream out) ： 创建一个指定序列化流对象，需要传入一个字节输出流对象。
            特有方法
                4.public final void writeObject (Object obj) : 将指定的对象以字节方式写出到指定文件
         */
        //1.创建序列化流
        FileOutputStream fos = new FileOutputStream("day11\\dd\\student2.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        //2.序列化对象
        Student student = new Student("张三",18);
        oos.writeObject(student);

        //3.关闭流
        oos.close();
    }
}
