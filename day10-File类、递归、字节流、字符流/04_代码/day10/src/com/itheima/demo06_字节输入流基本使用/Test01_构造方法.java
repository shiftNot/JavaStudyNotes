package com.itheima.demo06_字节输入流基本使用;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test01_构造方法 {
    public static void main(String[] args) throws FileNotFoundException {
        /*
            介绍
                java.io.InputStream抽象类是所有字节输入流的父类,主要用来读字节数据到内存中。
                java.io.FileInputStream 文件输入流，字节输入流常用子类，将数据读取到内存中。
            构造方法
                FileInputStream(File file)：创建文件输入流以读取，由指定的File对象表示要连接的文件。
                FileInputStream(String name)：创建文件输入流以读取，由指定的文件路径名表示要连接的文件。
            注意:创建一个流对象时，必须传入文件路径，且该路径下，如果没有该文件,会抛出文件不存在异常。

         */
        //创建指定存在文件的字节输入流对象
        FileInputStream fis1 = new FileInputStream("day10\\bb\\a.txt");
        FileInputStream fis2 = new FileInputStream(new File("day10\\bb\\b.txt"));

        //创建字节输入流对象  文件不存在会报错：FileNotFoundException: day10\bb\f.txt (系统找不到指定的文件。)
        //FileInputStream fis3 = new FileInputStream("day10\\bb\\f.txt");

    }
}
