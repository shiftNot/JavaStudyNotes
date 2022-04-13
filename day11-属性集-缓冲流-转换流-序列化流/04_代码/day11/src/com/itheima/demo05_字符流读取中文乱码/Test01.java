package com.itheima.demo05_字符流读取中文乱码;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test01 {
    public static void main(String[] args) throws Exception {
        //FileReader：读取字符时默认采用系统编码【idea的默认编码 UTF-8】进行读取 在读取UTF-8编码的文件时不会乱码
        //             但是读取GBK编码的文件时会出现乱码  原因就是：编码和解码所使用的字符集不一致 导致无法正常解码
        // 如何解决乱码：保证编码和解码时使用的字符编码集一致即可   1.将文件的编码修改为UTF-8  2.设置以指定的字符编码集读取|写入文件【推荐】
        //1.创建字符输入流对象  关联源文件路径
        //FileReader fr = new FileReader("day11\\cc\\gbk.txt");
        FileReader fr = new FileReader("day11\\cc\\utf-8.txt");

        //2.读取
        int c;
        while((c=fr.read())!=-1){
            System.out.println("c = " + (char)c);
        }

        //3.关闭流
        fr.close();

    }
}
