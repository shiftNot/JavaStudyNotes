package com.itheima.demo05_字节输出流基本使用;

import java.io.File;
import java.io.FileOutputStream;

public class Test04_写一个指定范围的字节数组 {
    public static void main(String[] args) throws Exception{
        /*
            常用方法
                public void close()：关闭此输出流并释放与此流相关联的任何系统资源。
                public void write(int b)：将指定的字节写入此输出流。
                public void write(byte[] b)：将 b.length字节从指定的字节数组写入此输出流。
                public void write(byte[] b, int off, int len)：从指定字节数组,按照偏移量写入len个字节。
         */

        //1.创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("day10\\bb\\c.txt");

        //2.写一个字节数组数据
        byte[] bytes = {97,98,99,100,101};
        fos.write(bytes,0,2);

        //3.关闭流 释放资源
        fos.close();
    }
}
