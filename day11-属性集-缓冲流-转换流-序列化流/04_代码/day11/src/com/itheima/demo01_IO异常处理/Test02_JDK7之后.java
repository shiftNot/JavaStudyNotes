package com.itheima.demo01_IO异常处理;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02_JDK7之后 {
    public static void main(String[] args){
        //需求：将aa目录下的ml.jpg 复制一份命名为mlCopy01.jpg
        //分析：读写复制

        //try()-catch      try...with...resources
        /*
            try(创建流对象的语句，如果有多个使用;隔开){

                }catch(异常类型 变量名){

                }
           好处：就是程序中要关闭的资源 不用再进行手动关闭了  当执行执行完成之后会自动关闭【程序代码执行完毕 自动关闭流对象】

           以后写代码：
                常见：try-catch-finally
                try...with...resources
         */

        try (
                //1.1：创建字节输入流对象 关联源文件路径
                FileInputStream  fis = new FileInputStream("day11\\aa\\ml.jpg");

                //1.2：创建字节输出流对象  关联目的地文件路径
                FileOutputStream  fos = new FileOutputStream("day11\\aa\\mlCopy01.jpg");
            ){
            //1.创建流对象


            //2.执行操作：循环读写
            //2.1:定义一个byte数组 用于存储读取到的字节数据
            byte[] bytes = new byte[8192];
            //2.2：定义一个int变量，用来存储读取到字节数组中数据的长度
            int len;
            //2.3：循环读写字节数据
            while((len=fis.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
