package com.itheima.demo09_反序列化注意事项;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test02_反序列化 {
    public static void main(String[] args) throws Exception {
        /*
            反序列化注意事项：
                1.JAVA反序列化对象，如果找不到对应class文件，抛出一个 ClassNotFoundException 异常。
                2.JAVA反序列化对象，能找到class文件，但是class文件在序列化对象后发生变化，反序列化操作，抛出一个InvalidClassException异常。
            解决办法
                问题1解决：build --> rebuild 模块
                问题2解决：Serializable 接口给需要序列化的类，提供了一个序列版本号的静态常量 serialVersionUID 。该常量的目的在于验证序列化的对象和对应类是否版本匹配。

         */

        //1.创建反序列流对象
        FileInputStream fis = new FileInputStream("day11\\dd\\student2.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        //2.重构对象  读取文件中对象二进制数据还原为一个对象
        Object object = ois.readObject();
        //System.out.println("object = " + object);

        Student student = (Student) object;

        //类导包错误：ClassCastException: com.itheima.demo09_反序列化注意事项.Student cannot be cast to com.itheima.demo07_序列化和反序列化.Student
        //com.itheima.demo07_序列化和反序列化.Student student = (com.itheima.demo07_序列化和反序列化.Student) object;

        System.out.println("student = " + student);

        //3.关闭流
        ois.close();
    }
}
