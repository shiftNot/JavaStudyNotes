package com.itheima.demo04_递归;

import java.io.File;

public class Test04_递归搜索java文件 {
    public static void main(String[] args) {
        /*
            需求：要求搜索出day10目录下的所有java文件 打印在控制台显示
            分析：
                1.由于使用File的listFiles方法只能得到当前目录的子文件和子目录file对象
                2.所以需要将当前目录的子目录继续传入进行遍历 获取子子目录和文件  因此 需要使用递归
            实现思路：
                //1.获取当前目录下的所有子文件和子目录
                //2.循环遍历所有的子文件和子目录
                //3.在循环遍历中判断 文件的类型  是文件还是目录
                //3.1：如果是文件 判断是不是java类型文件  是 就打印输出到控制台
                //3.2：如果是文件夹 就递归

         */
        //1.传递一个目录名称   2.传递一个目录对应的File对象【推荐】
        File file = new File("day10");
        searchFile(file);
    }

    public static void searchFile(File file){
        //1.获取当前目录下的所有子文件和子目录
        File[] files = file.listFiles();
        //2.循环遍历所有的子文件和子目录
        //files==null  就不再进入遍历了  就是递归的出口
        if(files!=null){
            for (File file1 : files) {
                //3.在循环遍历中判断 文件的类型  是文件还是目录
                //3.1：如果是文件 判断是不是java类型文件  是 就打印输出到控制台
                if(file1.isFile() && file1.getName().endsWith(".java")){
                    System.out.println(file1);
                }

                //3.2：如果是文件夹 就递归
                if(file1.isDirectory()){
                    searchFile(file1);
                }
            }
        }
    }
}
