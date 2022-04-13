package com.itheima.demo06_转换流;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Test01_转换输入流 {
    public static void main(String[] args) throws Exception{

        /*
            概述
                java.io.InputStreamReader转换输入流，Reader的子类,所以是字符输入流,
                可以将字节输入流转换为字符输入流;
                可以指定编码读数据,如果没有指定编码,使用的就是平台默认的编码
            构造方法
                InputStreamReader(InputStream in): 创建使用默认字符集的字符输入流。
                InputStreamReader(InputStream in, String charsetName): 创建指定字符集的字符输入流。
         */

        //注意：如果没有指定字符编码集 则默认使用当前系统的字符编码 【idea UTF-8】
        //1.创建转换输入流对象
        //InputStreamReader isr = new InputStreamReader(new FileInputStream("day11\\cc\\gbk.txt"));
        InputStreamReader isr = new InputStreamReader(new FileInputStream("day11\\cc\\gbk.txt"),"GBK");

        //2.读取
        int c;
        while((c=isr.read())!=-1){
            System.out.println("c = " + (char)c);
        }

        //3.关闭流
        isr.close();
    }
}
