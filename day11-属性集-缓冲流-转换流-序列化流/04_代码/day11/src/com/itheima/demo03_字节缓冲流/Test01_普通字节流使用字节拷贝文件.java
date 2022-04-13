package com.itheima.demo03_字节缓冲流;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test01_普通字节流使用字节拷贝文件 {
    public static void main(String[] args) throws Exception {
        //需求：使用普通字节流一个字节一个字节复制文件 复制a.wmv 叫aCopy01.wmv

        //记录程序开始执行时间对应的毫秒数
        long start = System.currentTimeMillis();

        //这里的a.wmv 你们可以自己随便找一个大文件替换
        //1.创建流对象
        FileInputStream fis = new FileInputStream("day11\\bb\\a.wmv");
        FileOutputStream fos = new FileOutputStream("day11\\bb\\aCopy01.wmv");

        //2.循环读写
        int b;
        while((b=fis.read())!=-1){
            fos.write(b);
        }

        //3.关闭流
        fos.close();
        fis.close();

        //记录程序执行完毕时的毫秒数
        long end = System.currentTimeMillis();

        System.out.println("总共发了"+(end-start)+"ms");//430820ms
    }
}
