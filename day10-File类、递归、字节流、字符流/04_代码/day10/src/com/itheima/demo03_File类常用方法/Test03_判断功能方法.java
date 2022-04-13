package com.itheima.demo03_File类常用方法;

import java.io.File;
import java.io.IOException;

public class Test03_判断功能方法 {
    public static void main(String[] args) throws IOException {
        /*
        判断功能方法：
            public boolean exists():此File表示的文件或目录是否实际存在。
            public boolean isDirectory():此File表示的是否为目录。  不存在返回false
            public boolean isFile():此File表示的是否为文件。       不存在返回false
         */

        File f1 = new File("day10\\aa\\a.txt");
        File f2 = new File("day10\\aa\\aa.txt");


        File f3 = new File("day10\\aa");
        File f4 = new File("day10\\cc");




        System.out.println("a.txt是否存在 = " + f1.exists()); //true
        System.out.println("aa.txt是否存在 = " + f2.exists());//false

        System.out.println("aa文件夹是否存在 = " + f3.exists());//true
        System.out.println("cc文件夹是否存在 = " + f4.exists());//false



        System.out.println("a.txt是否是文件 = " + f1.isFile()); //t
        System.out.println("aa.txt是否是文件 = " + f2.isFile());//false 因为aa.txt不存在 所以系统不知道它将会是文件还是文件夹 返回false

        System.out.println("aa是否是文件夹 = " + f3.isDirectory());//t
        System.out.println("cc是否是文件夹 = " + f4.isDirectory());//false 因为cc不存在 所以系统不知道它将会是文件还是文件夹 返回false


        //aa.txt可以是一个目录   cc也可以是一个文件
        f2.mkdir();
        f4.createNewFile();

    }
}
