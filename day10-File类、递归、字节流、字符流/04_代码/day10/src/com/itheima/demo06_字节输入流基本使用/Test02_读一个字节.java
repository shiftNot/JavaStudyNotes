package com.itheima.demo06_字节输入流基本使用;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test02_读一个字节 {
    public static void main(String[] args) throws IOException {
        /*
            常用方法
                public void close():关闭此输入流并释放与此流相关联的任何系统资源。
                public int read():从输入流读取数据的下一个字节。如果下一个字节不存在，文件数据读取完毕，返回-1
                public int read(byte[] b):从输入流中读取一些字节数，并将它们存储到字节数组b中节。
         */
        //需求：把bb目录下的a.txt中数据全部读取出来

        //1.创建字节输入流对象  关联源文件路径地址
        FileInputStream fis = new FileInputStream("day10\\bb\\a.txt");

        //2.读字节数据【一个一个读】
        /*int b1 = fis.read();
        //System.out.println("b1 = " + b1);
        System.out.println("b1 = " + (char)b1);

        int b2 = fis.read();
        System.out.println("b2 = " + (char)b2);

        int b3 = fis.read();
        System.out.println("b3 = " + (char)b3);

        int b4 = fis.read();
        System.out.println("b4 = " + b4);*/

        //可以将上面代码使用循环进行优化  一旦发现读取到的字节为-1 则退出循环 不再读取
        int b = 0;
        while((b=fis.read())!=-1){
            System.out.println("b = " + (char)b);
        }


        //3.关闭流 释放资源
        fis.close();

    }
}
