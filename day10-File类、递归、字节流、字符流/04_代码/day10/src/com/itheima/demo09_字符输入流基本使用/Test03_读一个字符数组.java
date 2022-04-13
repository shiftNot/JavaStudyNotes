package com.itheima.demo09_字符输入流基本使用;

import java.io.FileReader;

public class Test03_读一个字符数组 {
    public static void main(String[] args) throws Exception {
        /*
            常用方法
                public void close():关闭此流并释放与此流相关联的任何系统资源。
                public int read():从输入流读取一个字符,读到文件的末尾返回-1。
                public int read(char[] cbuf):从输入流中读取一些字符，并将它们存储到字符数组 cbuf中 。返回读取到的字符个数,读到文件的末尾返回-1
         */

        //1.创建字符输入流对象 关联源文件地址
        FileReader fr = new FileReader("day10\\dd\\a.txt");

        //2.读一个字符数组
        char[] chars = new char[1024];
        int len;
        while((len=fr.read(chars))!=-1){
            System.out.println(new String(chars,0,len));
        }


        //3.关闭流 释放资源
        fr.close();

    }
}
