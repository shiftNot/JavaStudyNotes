package com.itheima.demo05_字节输出流基本使用;

import java.io.File;
import java.io.FileOutputStream;

public class Test03_写一个字节数组 {
    public static void main(String[] args) throws Exception{
        /*
            介绍
                java.io.OutputStream 抽象类是所有字节输出流的父类,用来写出字节数据的。
                java.io.FileOutputStream 文件输出流，字节输出流常用子类，用于将数据写出到文件。
            构造方法
                public FileOutputStream(File file)：创建文件输出流以写入由指定的 File对象表示的文件。
                public FileOutputStream(String name):创建文件输出流以指定的名称写入文件。
            常用方法
                public void close()：关闭此输出流并释放与此流相关联的任何系统资源。
                public void write(int b)：将指定的字节写入此输出流。
                public void write(byte[] b)：将 b.length字节从指定的字节数组写入此输出流。
                public void write(byte[] b, int off, int len)：从指定字节数组,按照偏移量写入len个字节。

            构造方法注意：
                1.创建字节输出流对象时，如果指定的文件不存在 就会直接创建一个空文件
                2.如果指定文件存在 则会覆盖源文件【清空源文件中的数据】
                3.如果指定的文件父目录不存在，则会报错 FileNotFoundException: day10\cc\b.txt (系统找不到指定的路径。)

         */

        //1.创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("day10\\bb\\b.txt");

        //2.写一个字节数组数据
        byte[] bytes = {97,98,99,100,101};
        fos.write(bytes);

        //3.关闭流 释放资源
        fos.close();


    }
}
