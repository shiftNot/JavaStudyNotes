package com.itheima.demo05_字节输出流基本使用;

import java.io.File;
import java.io.FileOutputStream;

public class Test01_构造方法 {
    public static void main(String[] args) throws Exception{
        /*
            介绍
                java.io.OutputStream 抽象类是所有字节输出流的父类,用来写出字节数据的。
                java.io.FileOutputStream 文件输出流，字节输出流常用子类，用于将数据写出到文件。
            构造方法
                public FileOutputStream(File file)：创建文件输出流以写入由指定的 File对象表示的文件。
                public FileOutputStream(String name):创建文件输出流以指定的名称写入文件。

            构造方法注意：
                1.创建字节输出流对象时，如果指定的文件不存在 就会直接创建一个空文件
                2.如果指定文件存在 则会覆盖源文件【清空源文件中的数据】
                3.如果指定的文件父目录不存在，则会报错 FileNotFoundException: day10\cc\b.txt (系统找不到指定的路径。)

         */

        //要想以字节为单位 将内存中数据写入到硬盘文件中  就需要创建一个字节输出流对象
        File file = new File("day10\\bb\\a.txt");
        FileOutputStream fos01 = new FileOutputStream(file);

        FileOutputStream fos02 = new FileOutputStream("day10\\bb\\b.txt");

        //创建文件的所在父目录不存在
        FileOutputStream fos03 = new FileOutputStream("day10\\cc\\b.txt");

    }
}
