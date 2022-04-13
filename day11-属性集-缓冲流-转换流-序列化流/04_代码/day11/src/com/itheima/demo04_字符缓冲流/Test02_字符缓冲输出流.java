package com.itheima.demo04_字符缓冲流;

import java.io.*;

public class Test02_字符缓冲输出流 {
    public static void main(String[] args) throws IOException {
        /*
            构造方法
                public BufferedReader(Reader in):创建一个 新的缓冲输入流。
                public BufferedWriter(Writer out)： 创建一个新的缓冲输出流。
            特有方法
                BufferedReader类：public String readLine(): 读一行文字，读取不到内容，返回null。
                BufferedWriter：public void newLine(): 写一行行分隔符,由系统属性定义符号。
         */

        //1.创建一个字符缓冲输出流
        FileWriter fileWriter = new FileWriter("day11\\bb\\b.txt");
        BufferedWriter br = new BufferedWriter(fileWriter);

        //2.写操作
        br.write("静夜思");
        br.newLine();
        br.write("窗前明月光");
        br.newLine();
        br.write("疑是地上霜");
        br.newLine();

        //3.关闭流
        br.close();
    }
}
