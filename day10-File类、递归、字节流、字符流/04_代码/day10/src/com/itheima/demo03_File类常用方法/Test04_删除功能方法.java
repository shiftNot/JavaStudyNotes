package com.itheima.demo03_File类常用方法;

import java.io.File;

public class Test04_删除功能方法 {
    public static void main(String[] args) {
        /*
            删除功能
                public boolean delete() ：删除由此File表示的文件或空文件夹,不能删除非空文件夹。
                    注意：
                        1.删除成功返回true
                        2.不存在的文件或目录 删除返回false
                        3.不能删除非空目录
                        4.使用delete方法删除文件 不进入回收站

         */

        File f1 = new File("day10\\cc");
        File f2 = new File("day10\\aa\\aa.txt");

        System.out.println("day10下的cc文件是否删除 = " + f1.delete());
        System.out.println("aa目录下的aa.txt文件夹是否删除 = " + f2.delete());

        File f3 = new File("day10\\aa");
        System.out.println("day10目录下的aa文件夹是否删除 = " + f3.delete());
    }
}
