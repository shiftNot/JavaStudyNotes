package com.itheima.demo08_字节流读取中文乱码;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test01 {
    public static void main(String[] args) throws Exception {
        //需求：读取dd下的a.txt中的数据
        //注意：在读取文本文档时 建议使用字符流 读取 一般不会出现中文乱码问题  使用字节流就很容易出现乱码
        //因为 一个中文如果使用gbk编码占用2个字节  使用utf-8编码占用3个字节
        //1.创建字节输入流对象  关联源文件路径
        FileInputStream fis = new FileInputStream("day10\\dd\\a.txt");

        //2.读取数据
        byte[] bytes = new byte[2];
        int len;
        while((len=fis.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }

        //3.关闭流
        fis.close();

    }
}
