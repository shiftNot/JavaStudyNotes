package com.itheima.demo05_字节输出流基本使用;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test05_追加续写 {
    public static void main(String[] args) throws IOException {
        /*
            构造方法:append的值，true 表示追加数据，false 表示清空原有数据。
                public FileOutputStream(File file, boolean append):创建文件输出流以写入由指定的 File对象表示的文件。
                public FileOutputStream(String name, boolean append):创建文件输出流以指定的名称写入文件。
         */

        //1.创建一个字节输出流对象  关联目的地文件【写到哪个文件中】
        FileOutputStream fos = new FileOutputStream("day10\\bb\\d.txt", true);

        //2.写数据到文件
        fos.write(97);
        fos.write(98);
        fos.write(99);

        //3.关闭流 释放资源
        fos.close();
    }
}
