package com.itheima.demo03_字节缓冲流;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test04_普通字节流使用字节数组拷贝文件 {
    public static void main(String[] args) throws Exception {
        /*
            构造方法
                public BufferedInputStream(InputStream in):创建一个 新的字节缓冲输入流。
                public BufferedOutputStream(OutputStream out)： 创建一个新的字节缓冲输出流
         */
        //需求：使用普通字节流一个字节一个字节复制文件 复制a.wmv 叫aCopy01.wmv

        //记录程序开始执行时间对应的毫秒数
        long start = System.currentTimeMillis();

        //1.创建流对象
        FileInputStream fis = new FileInputStream("day11\\bb\\a.wmv");
        FileOutputStream fos = new FileOutputStream("day11\\bb\\aCopy04.wmv");

        //2.循环读写
        byte[] bytes = new byte[8192];
        int len;
        while((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }

        //3.关闭流  关闭缓冲流 基本的字节流对象也会随着一起关闭
        fos.close();
        fis.close();

        //记录程序执行完毕时的毫秒数
        long end = System.currentTimeMillis();

        System.out.println("总共发了"+(end-start)+"ms"); //211ms
    }
}
