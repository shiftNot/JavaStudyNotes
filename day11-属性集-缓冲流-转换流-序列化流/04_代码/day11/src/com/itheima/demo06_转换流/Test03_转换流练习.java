package com.itheima.demo06_转换流;

import java.io.*;

public class Test03_转换流练习 {
    public static void main(String[] args) throws Exception {
        //需求：将GBK编码的文本文件，转换为UTF-8编码的文本文件。
        /*
            分析：
                核心：读写操作
                读：使用GBK编码读取     InputStreamReader
                写：使用UTF-8编码写入   OutputStreamWriter
         */
        //1.创建流对象
        InputStreamReader isr = new InputStreamReader(new FileInputStream("day11\\cc\\gbk.txt"),"GBK");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("day11\\cc\\gbk_utf-8.txt"), "utf-8");

        //2.执行读写
        int c;
        while ((c=isr.read())!=-1){
            osw.write(c);
        }

        //3.关闭流
        osw.close();
        isr.close();


    }
}
