package com.itheima.demo06_转换流;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Test02_转换输出流 {
    public static void main(String[] args) throws Exception{
        /*
            java.io.OutputStreamWriter 转换输出流，是Writer的子类,所以是字符输出流
            作用:
                指定编码写数据,如果没有指定编码,那么使用默认编码【idea 默认UTF-8】
                可以将字节输出流转换为字符输出流
            构造方法
                OutputStreamWriter(OutputStream in): 创建使用默认字符集的字符输出流。
                OutputStreamWriter(OutputStream in, String charsetName): 创建指定字符集的字符输出流。
         */
        //1.创建转换输出流对象  关联目的地文件路径 [还可以指定编码方式]
        //OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("day11\\cc\\a.txt"));
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("day11\\cc\\aa.txt"),"gbk");

        //2.写数据
        osw.write("中国");

        //3.关闭流
        osw.close();

    }
}
