package com.itheima.demo07_图片复制;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01 {
    public static void main(String[] args) throws IOException {
        //需求：将bb目录下的ml.jpg复制到cc目录下 并设置名称为mlCopy01.jpg
        //注意：图片、视频、音乐 ... 二进制文件的复制 只能使用字节流操作 不能使用字符流【计算机存储是按字节存储的】
        //1.创建字节输入流对象，关联源文件路径
        FileInputStream fis = new FileInputStream("day10\\bb\\ml.jpg");

        //2.创建字节输出流对象，关联目的地路径
        FileOutputStream fos = new FileOutputStream("day10\\cc\\mlCopy01.jpg");

        //3.循环读写【一个字节一个字节的进行】
        int b;//声明一个字节
        //循环读一个字节
        while((b=fis.read())!=-1){
            //循环写一个字节
            fos.write(b);
        }

        //4.关闭流 释放资源  【建议先开后关】
        fos.close();
        fis.close();


    }
}
