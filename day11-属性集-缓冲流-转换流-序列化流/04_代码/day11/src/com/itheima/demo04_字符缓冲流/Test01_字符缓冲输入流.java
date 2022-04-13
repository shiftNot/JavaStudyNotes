package com.itheima.demo04_字符缓冲流;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test01_字符缓冲输入流 {
    public static void main(String[] args) throws IOException {
        /*
            构造方法
                public BufferedReader(Reader in):创建一个 新的缓冲输入流。
                public BufferedWriter(Writer out)： 创建一个新的缓冲输出流。
            特有方法
                BufferedReader类：public String readLine(): 读一行文字，读取不到内容，返回null。
                BufferedWriter：public void newLine(): 写一行行分隔符,由系统属性定义符号。
         */

        //1.创建一个字符缓冲输入流
        BufferedReader br = new BufferedReader(new FileReader("day11\\bb\\a.txt"));

        //2.使用readLine方法读取
        /*String line1 = br.readLine();
        System.out.println("line1 = " + line1);

        String line2 = br.readLine();
        System.out.println("line1 = " + line2);

        String line3 = br.readLine();
        System.out.println("line1 = " + line3);

        String line4 = br.readLine();
        System.out.println("line1 = " + line4);

        String line5 = br.readLine();
        System.out.println("line1 = " + line5);

        String line6 = br.readLine();
        System.out.println("line1 = " + line6);*/

        //循环优化：
        //2.1：定义一个String类型变量  表示一行数据
        String line;
        //2.2：循环读取
        while((line=br.readLine())!=null){
            System.out.println("line = " + line);
        }

        //3.关闭流 释放资源
        br.close();
    }
}
