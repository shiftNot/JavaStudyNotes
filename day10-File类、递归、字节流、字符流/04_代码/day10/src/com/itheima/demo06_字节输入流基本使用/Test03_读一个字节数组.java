package com.itheima.demo06_字节输入流基本使用;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test03_读一个字节数组 {
    public static void main(String[] args) throws IOException {
        /*
            常用方法
                public void close():关闭此输入流并释放与此流相关联的任何系统资源。
                public int read():从输入流读取数据的下一个字节。如果下一个字节不存在，文件数据读取完毕，返回-1
                public int read(byte[] b):从输入流中读取一些字节数，并将它们存储到字节数组b中。如果读取完毕 返回字节数组长度为-1
         */
        //需求：把bb目录下的a.txt中数据全部读取出来

        //1.创建字节输入流对象  关联源文件路径地址
        FileInputStream fis = new FileInputStream("day10\\bb\\a.txt");

        //2.读字节数组数据
        //2.1：创建一个字节数组 用来存储临时读取到数据
        byte[] bytes = new byte[8092];

        //2.2：执行读取操作  将文件中数据存入到字节数组中
        /*int len1 =  fis.read(bytes);
        System.out.println("bytes = "+ Arrays.toString(bytes) +" len1="+len1);//第一次读取[97,98]  2

        int len2 =  fis.read(bytes);
        System.out.println("bytes = "+ Arrays.toString(bytes)+" len2="+len2);//第二次读取[99,98]   1

        int len3 =  fis.read(bytes);
        System.out.println("bytes = "+ Arrays.toString(bytes)+" len3="+len3);//第三次读取[99,98]  -1*/

        int len = 0;
        while((len=fis.read(bytes))!=-1){
            //System.out.println("bytes = " + Arrays.toString(bytes));
            System.out.println(new String(bytes,0,len));
        }

        //3.关闭流 释放资源
        fis.close();

    }
}
