package com.itheima.demo10_字符输出流基本使用;

import java.io.FileWriter;

public class Test08_追加续写 {
    public static void main(String[] args) throws Exception {

        //1.创建字符输出流对象  关联目的地文件路径
        FileWriter fw = new FileWriter("day10\\dd\\d.txt",true);

        //2.写一个字符
        fw.write("程序员");

        //3.关闭流 释放资源
        fw.close();

    }

}
