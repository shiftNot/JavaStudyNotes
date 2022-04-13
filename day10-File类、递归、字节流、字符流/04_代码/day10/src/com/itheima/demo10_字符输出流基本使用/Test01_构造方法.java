package com.itheima.demo10_字符输出流基本使用;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test01_构造方法 {
    public static void main(String[] args) throws IOException {
        /*
            以内存为基准：
                从硬盘输入到内存：输入流  读取文件数据
                从内存输出到硬盘：输出流  写数据到文件
            按照操作流的类型划分：
                字节输入流InputStream FileInputStream   字节输出流OutputStream FileOutputStream
                字符输入流Reader      FileReader        字符输出流Writer       FileWriter
            操作套路：
                1.创建流对象

                2.执行操作
                    输入流读：read()
                    输出流写：write()

                3.关闭流
                   close

            介绍
                java.io.Writer 抽象类表示字符输出流的所有类的超类，规定了将字符信息写出到目的地共性方法。
                java.io.FileWriter文件输出流，字符输出流常用子类，(使用系统默认的字符编码和默认字节缓冲区)将数据写出到文件。
            构造方法
                FileWriter(File file):创建一个新的 FileWriter，给定要读取的File对象。
                FileWriter(String fileName):创建一个新的 FileWriter，给定要读取的文件的名称。
            注意:
                如果路径表示的文件不存在,就会自动创建一个新的空文件
                如果路径表示的文件存在,就会清空该文件中原来的数据

         */

        //创建字符输出流对象  关联目的地文件路径
        FileWriter fr1 = new FileWriter("day10\\dd\\b.txt");
        FileWriter fr2 = new FileWriter(new File("day10\\dd\\c.txt"));

    }
}
