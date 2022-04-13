package com.itheima.demo03_File类常用方法;

import java.io.File;

public class Test02_获取功能方法 {
    public static void main(String[] args) {
        /*
        获取功能
            public String getAbsolutePath() :返回此File的绝对路径名字符串。
            public String getPath()  	：将此File转换为路径名字符串。获取构造路径
            public String getName()  	：返回由此File表示的文件或目录的名称。     【用的比较多】
            public long length()  		：返回由此File表示的文件的字节大小,注意不能获取文件夹的字节大小。
         */

        //1.获取文件或文件名绝对路径
        File f1 = new File("D:\\workspace\\java126\\day10\\aa\\a.txt");
        System.out.println("f1的绝对路径 = " + f1.getAbsoluteFile());
        System.out.println("f1的构造路径 = " + f1.getPath());
        System.out.println("f1的文件名 = " + f1.getName());
        System.out.println("f1的文件字节大小 = " + f1.length());



        File f2 = new File("day10\\aa\\a.txt");
        System.out.println("f2的绝对路径 = " + f2.getAbsoluteFile());
        System.out.println("f2的构造路径 = " + f2.getPath());
        System.out.println("f2的文件名 = " + f2.getName());
        System.out.println("f2的文件字节大小 = " + f2.length());


        File f3 = new File("day10\\aa");
        System.out.println("f3的文件夹名称 = " + f3.getName());
        System.out.println("f3的文件夹字节大小 = " + f3.length());
    }
}
