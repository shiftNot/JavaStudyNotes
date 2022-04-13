package com.itheima.demo05_字节输出流基本使用;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test06_写字符串和换行 {
    public static void main(String[] args) throws IOException {
        /*
            写一首诗
                静夜思
                窗前明月光
                疑是地上霜
                举头望明月
                低头思故乡
         */
        //使用字节输出流写字符串数据到文件中   字符串--转换-->字节-->写入
        //1.创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("day10\\bb\\e.txt");

        //2.写字节数据
        fos.write("静夜思\r\n".getBytes());
        fos.write("窗前明月光\r\n".getBytes());
        fos.write("疑是地上霜\r\n".getBytes());
        fos.write("举头望明月\r\n".getBytes());
        fos.write("低头思故乡\r\n".getBytes());


        //3.关闭流
        fos.close();

    }
}
