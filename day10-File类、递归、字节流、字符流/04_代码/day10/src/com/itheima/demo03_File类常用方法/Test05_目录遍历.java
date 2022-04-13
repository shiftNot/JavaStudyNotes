package com.itheima.demo03_File类常用方法;

import java.io.File;

public class Test05_目录遍历 {
    public static void main(String[] args) {
        /*
            目录遍历：
                public String[] list():返回一个String数组，表示该File目录中的所有子文件或目录的名称。
                public File[] listFiles():返回一个File数组，表示该File目录中的所有的子文件或目录的路径。【推荐使用的】
                注意：以上方法 只进行遍历当前目录下的子文件或子目录  不遍历孙子..文件目录


         */
        File f1 = new File("day10");

        String[] list1 = f1.list();
        for (String s : list1) {
            System.out.println("s = " + s);
        }

        File[] list2 = f1.listFiles();
        for (File file : list2) {
            System.out.println("file = " + file);
        }


        //遍历一个不存在的目录  files为null  建议 在遍历的时候做一下非空判断
        File f2 = new File("day10\\cc");
        File[] files = f2.listFiles();
        System.out.println("files = " + files);

        if(files!=null){
            for (File file : files) {
                System.out.println("file = " + file);
            }
        }

    }
}
