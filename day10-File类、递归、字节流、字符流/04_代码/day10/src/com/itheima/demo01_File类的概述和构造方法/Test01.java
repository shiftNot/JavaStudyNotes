package com.itheima.demo01_File类的概述和构造方法;

import java.io.File;

public class Test01 {
    public static void main(String[] args) {
        /*
            概述
                java.io.File 是文件和目录路径名的抽象表示，主要用于文件和目录的创建、查找和删除等操作。
            常用构造方法
                public File(String pathname):通过给定的路径名字符串转换为抽象路径名来创建新的File实例。
                public File(String parent,String child):从父路径名字符串和子路径名字符串创建新的File实例。
                public File(File parent, String child):从父抽象路径名和子路径名字符串创建新的File实例。
            注意:创建File对象时,如果传入的文件或者文件夹路径不存在,依然不影响File对象的创建
         */

        //需求：创建a.txt文件的file对象   eg：a.txt路径：D:\workspace\java126\day10\aa\a.txt

        //方式一：【推荐】
        File f1 = new File("D:\\workspace\\java126\\day10\\aa\\a.txt");
        System.out.println("f1 = " + f1);


        //方式二： 一般parent父路径设置为文件所在目录路径  子路径就写文件名
       File f2 = new File("D:\\workspace\\java126\\day10\\aa","a.txt");
       //File f2 = new File("D:\\workspace\\java126\\day10","\\aa\\a.txt");
        System.out.println("f2 = " + f2);

        //方式三：
        File parent = new File("D:\\workspace\\java126\\day10\\aa");
        File f3 = new File(parent, "a.txt");
        System.out.println("f3 = " + f3);

        //注意：创建File对象时,如果传入的文件或者文件夹路径不存在,依然不影响File对象的创建,但是在之后的使用中会出现问题
        File f4 = new File("E:\\workspace\\java126\\day10\\aa\\aa.txt");
        System.out.println("f4 = " + f4);

    }

}
