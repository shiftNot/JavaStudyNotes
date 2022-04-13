package com.itheima.demo05_字节输出流基本使用;

import java.io.File;
import java.io.FileOutputStream;

public class Test02_写一个字节 {
    public static void main(String[] args) throws Exception{
        /*
            常用方法
                public void close()：关闭此输出流并释放与此流相关联的任何系统资源。
                public void write(int b)：将指定的字节写入此输出流。
                public void write(byte[] b)：将 b.length字节从指定的字节数组写入此输出流。
                public void write(byte[] b, int off, int len)：从指定字节数组,按照偏移量写入len个字节。
            备注：
                字节是二进制数据的单位。一个字节通常8位长。在多数的计算机系统中，一个字节是一个8位长的数据单位，大多数的计算机用一个字节表示一个字符、数字或其他字符。Eg：97=a
                1个字节 实际大小 -128-127
         */

        //要想以字节为单位 将内存中数据写入到硬盘文件中  就需要创建一个字节输出流对象
        //1.创建流对象
        FileOutputStream fos = new FileOutputStream("day10\\bb\\a.txt");

        //2.调用方法执行操作
        fos.write(97);
        fos.write(98);
        //fos.write(168);//168 一个字节存不下 最多存到127  所以写过去的只是168的部分字节数据 不是一个完整字节的数据
        fos.write(99);
        //3.关闭流 释放资源
        //fos.close();

    }
}
