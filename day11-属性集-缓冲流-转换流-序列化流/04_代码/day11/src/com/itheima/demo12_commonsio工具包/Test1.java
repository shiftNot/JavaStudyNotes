package com.itheima.demo12_commonsio工具包;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test1 {
    /*
        使用步骤
        1. 下载commons-io相关jar包
        2. 把commons-io-2.6.jar包复制到指定的Module的lib目录中
        3. 将commons-io-2.6.jar加入到classpath中 【右键 -- add as libary -- 选择 module libary】
        4.具体使用：1.创建类的对象 2.调用方法操作即可
     */

    public static void main(String[] args) throws Exception {
        //1.使用IOUtils拷贝文件
        /*FileInputStream input = new FileInputStream("day11\\aa\\ml.jpg");
        FileOutputStream output = new FileOutputStream("day11\\dd\\mlCopy.jpg");
        IOUtils.copy(input,output);*/

        //2.1：使用FileUtils拷贝文件
        // FileUtils.copyFileToDirectory(new File("day11\\aa\\b.txt"),new File("day11\\dd"));

        //2.2：使用FileUtils拷贝文件夹
        FileUtils.copyDirectoryToDirectory(new File("day11\\aa"),new File("day11\\dd"));
    }
}
