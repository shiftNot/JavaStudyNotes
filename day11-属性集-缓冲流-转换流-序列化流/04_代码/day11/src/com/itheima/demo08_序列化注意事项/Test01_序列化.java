package com.itheima.demo08_序列化注意事项;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test01_序列化 {
    public static void main(String[] args) throws Exception {
        /*
            序列化对象注意事项：
                1.如果一个类的对象要想进行序列化，则类必须实现java.io.Serializable标记接口，否则会抛出NotSerializableException。
                2.类中的属性需要可序列化。
                3.如果某属性不想序列化，须注明瞬态transient关键字修饰。

         */
        //1.创建序列化流
        FileOutputStream fos = new FileOutputStream("day11\\dd\\student1.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        //2.序列化对象
        Student student = new Student("张三",18,new Address("广东省"));
        oos.writeObject(student);

        //3.关闭流
        oos.close();
    }
}
