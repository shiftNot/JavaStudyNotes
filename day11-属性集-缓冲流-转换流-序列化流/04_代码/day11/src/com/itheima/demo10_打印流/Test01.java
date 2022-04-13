package com.itheima.demo10_打印流;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Test01 {
    public static void main(String[] args) throws FileNotFoundException {
        /*
            概述
                java.io.PrintStream类，该类能够方便地打印各种数据，是一种便捷的输出方式。
                在控制台输出时，System.out就是java.io.PrintStream类型的，只不过流向是由打印在控制台上。
            方法
                public PrintStream(String fileName)  ： 使用指定的文件名创建一个新的打印流。
                public void print(任意类型);打印任意类型的数据到目的地文件中,打印完不换行`
                public void println(任意类型);打印任意类型的数据到目的地文件中,打印完换行`
         */
        //需求：利用打印流，将数据输出到指定文本文件中。

        //1.创建打印流对象 关联了目的地文件
        PrintStream ps = new PrintStream("day11\\dd\\a.txt");

        //2.打印数据到文件中
        ps.print(97);
        ps.print(true);
        ps.print("中国");
        ps.println("--------------");
        ps.println(97);
        ps.println(true);
        ps.println("中国");

        //3.关闭流
        ps.close();
    }
}
