package com.itheima.demo02_properties;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Test03_写键值对数据到文件 {
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
            细节：
                1.首先和Properties对象交互的文件 我们一般命名为xxx.properties
                2.编写xxx.properties文件内容时，一般不建议存储中文
                3.在properties文件中键值对的表示，可以使用= 空格 冒号 分隔键值对  以第一次出现的位置为准  一般建议使用=分隔键值对数据

         */
        //需求：使用属性集的字符流形式，将“name=张三”从b1文件取出，并存储到b2文本文件。
        //1.创建Properties对象
        Properties p = new Properties();

        //2.想Properties对象中存入数据
        p.setProperty("k1","值1");
        p.setProperty("k2","v2");
        p.setProperty("k3","v3");

        //3.将Properties属性中的数据存储到文件中
        //p.store(new FileWriter("day11\\aa\\b.txt"),"shuaige");
       p.store(new FileOutputStream("day11\\aa\\c.txt"),"itheima");

    }
}
