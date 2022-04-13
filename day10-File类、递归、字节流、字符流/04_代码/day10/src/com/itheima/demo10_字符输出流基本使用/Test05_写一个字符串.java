package com.itheima.demo10_字符输出流基本使用;

import java.io.FileWriter;

public class Test05_写一个字符串 {
    public static void main(String[] args) throws Exception {
        /*
        常用方法
            public void close():关闭此输出流并释放与此流相关联的任何系统资源。
            public void flush() :刷新此输出流并强制任何缓冲的输出字符被写出。
            public void write(int c):写出一个字符。
            public void write(char[] cbuf)：将 cbuf.length字符从指定的字符数组写出此输出流。
            public void write(char[] b, int off, int len):从指定字节数组,按照偏移量写入len个字符。
            public void write(String str):写出一个字符串。
            public void write(String str, int off, int len) ，每次可以写出一个字符串的指定范围
     */

        //1.创建字符输出流对象  关联目的地文件路径
        FileWriter fw = new FileWriter("day10\\dd\\b.txt");

        //2.写一个字符
        char[] chars = {'a','b','c','d','e'};
        fw.write(chars,2,2);

        //3.关闭流 释放资源
        fw.close();
    }

}
