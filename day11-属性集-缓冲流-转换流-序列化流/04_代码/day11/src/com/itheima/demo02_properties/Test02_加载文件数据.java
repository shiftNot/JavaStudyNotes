package com.itheima.demo02_properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Test02_加载文件数据 {
    public static void main(String[] args) throws IOException {
        /*
            概述
                通过流对象，可以关联到某文件上，针对键值对在属性集与文本之间做存取键值对数据的操作。
                存储或读取的文本内容格式：键=值(每行一对数据)
            常用方法
                public void load(InputStream inStream)： 从字节输入流中读取键值对。
                public void load(Reader reader):从字符输入流中读取键值对。
                public void store(OutputStream out,String comments)：用字节输出流写出键值对
                public void store(Writer writer,String comments):用字符输出流写出键值对。
         */
        //需求：使用属性集的字符流形式，将“name=张三”从b1文件取出，并存储到b2文本文件。
        //1.创建Properties对象
        Properties p = new Properties();

        //2.调用load方法加载文件数据【通过流】
        /*FileInputStream fis = new FileInputStream("day11\\aa\\a.txt");
        p.load(fis);*/

        FileReader reader = new FileReader("day11\\aa\\a.txt");
        p.load(reader);

        //3.获取所有的数据遍历显示
        //获取Properties属性集中的所有键的集合
        Set<String> keys = p.stringPropertyNames();
        //遍历键集
        for (String key : keys) {
            //根据键获取值
            System.out.println(key+"="+p.getProperty(key));
        }

    }
}
