package com.itheima.demo04_字符缓冲流;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Test03_文本排序 {

    public static void main(String[] args) throws Exception {
        /*
        需求:请将指定文本信息恢复顺序。
        分析：
            读 -- 存List<Sting>  --> 排序 --> 写
            1.按行读取文本内容 BufferedReader
            2.将读取出来的文本内容存入到一个集合中  List<String>
            3.对list集合元素进行排序
            4.将list集合中的数据重新写入到文件中 按行写 BufferedWriter
        具体步骤：
            //1.创建字符缓冲输入流对象
            //2.定义一个List<String>类型的集合接收数据
            //3.将text.txt文本中的数据使用readLine按行读取处理存入到List集合中
            //4.关闭字符缓冲输入流对象
            //5.对List集合元素进行排序
            //6.创建字符缓冲输出流对象
            //7.循环遍历List集合元素 将其重新写入到text.txt文件中 每写一行 要进行换行处理newLine()
            //8.关闭符缓冲输出流对象
     */

        //1.创建字符缓冲输入流对象
        BufferedReader br = new BufferedReader(new FileReader("day11\\bb\\text.txt"));
        //此时不能提前创建字符输出流对象 原因：字符输入流和字符输出流操作的都是同一个文件 一旦提前创建字符输出流 会将源文件中的数据清空
        //如果读和写不是同一个文件  就可以提前创建输出流对象
        //BufferedWriter bw = new BufferedWriter(new FileWriter("day11\\bb\\text.txt"));

        //2.定义一个List<String>类型的集合接收数据
        ArrayList<String> list = new ArrayList<>();

        //3.将text.txt文本中的数据使用readLine按行读取处理存入到List集合中
        String line;
        while((line=br.readLine())!=null){
            list.add(line);
        }

        //4.关闭字符缓冲输入流对象
        br.close();

        //5.对List集合元素进行排序
        Collections.sort(list);

        //6.创建字符缓冲输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("day11\\bb\\text.txt"));

        //7.循环遍历List集合元素 将其重新写入到text.txt文件中 每写一行 要进行换行处理newLine()
        for (String s : list) {
            bw.write(s);
            bw.newLine();
        }

        //8.关闭字符缓冲输出流对象
        bw.close();

    }
}
