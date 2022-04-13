package com.itheima.demo03_File类常用方法;

import java.io.File;
import java.io.IOException;

public class Test01_创建功能方法 {
    public static void main(String[] args) throws IOException {
        /*
            创建功能
                public boolean createNewFile():当且仅当具有该名称的文件尚不存在时，创建一个新的空文件，该文件的父级目录需要先存在。
                public boolean mkdir():创建由此File表示的目录，该目录的父级目录需要先存在。
                public boolean mkdirs():创建由此File表示的目录，包括任何必需但不存在的父目录。

         */

        //需求1：创建一个空文件b.txt
        //1.创建b.txt的File对象
        //2.调用createNewFile方法
        //File f1 = new File("day10\\aa\\b.txt");
        //System.out.println("创建b.txt是否成功 = " + f1.createNewFile());

        //File f2 = new File("day10\\aa\\a.txt");//a.txt文件已经存在 创建失败
        //System.out.println("创建a.txt是否成功 = " + f2.createNewFile());//false

        //File f3 = new File("day10\\bb\\a.txt");// 由于a.txt的父目录bb不存在 出现IOException: 系统找不到指定的路径。
        //System.out.println("创建a.txt是否成功 = " + f3.createNewFile());//false

        //需求2：创建一个空目录 在aa下面创建一个bb目录
        //File f4 = new File("day10\\aa\\bb");
        //System.out.println("创建aa目录下的bb文件夹是否成功 = " + f4.mkdir());

        //File f5 = new File("day10\\bb\\cc");//由于cc文件夹的父目录bb不存在 出现IOException: 系统找不到指定的路径。
        //System.out.println("创建bb目录下的cc文件夹是否成功 = " + f5.mkdir());

        File f5 = new File("day10\\bb\\cc");//由于cc文件夹的父目录bb不存在 此时使用mkdirs可以创建成功  会先创建出bb，再在bb下创建出cc文件夹
        System.out.println("创建bb目录下的cc文件夹是否成功 = " + f5.mkdirs());




    }
}
