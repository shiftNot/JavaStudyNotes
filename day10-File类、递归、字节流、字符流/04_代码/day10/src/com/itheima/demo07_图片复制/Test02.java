package com.itheima.demo07_图片复制;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02 {
    public static void main(String[] args) throws IOException {
        //需求：将bb目录下的ml.jpg复制到cc目录下 并设置名称为mlCopy01.jpg
        //1.创建字节输入流对象，关联源文件路径
        FileInputStream fis = new FileInputStream("day10\\bb\\ml.jpg");

        //2.创建字节输出流对象，关联目的地路径
        FileOutputStream fos = new FileOutputStream("day10\\cc\\mlCopy02.jpg");

        //3.循环读写【一个读写一个字节数组】
        byte[] bytes = new byte[8192];
        int len;
        while((len=fis.read(bytes))!=-1){
            //注意：每次实际读取到多少个字节 就写入多少个字节
            fos.write(bytes,0,len);
        }

        //4.关闭流 释放资源  【建议先开后关】
        fos.close();
        fis.close();


    }
}
