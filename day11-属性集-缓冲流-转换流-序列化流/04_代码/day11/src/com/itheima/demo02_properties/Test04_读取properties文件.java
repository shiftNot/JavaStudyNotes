package com.itheima.demo02_properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class Test04_读取properties文件 {
    public static void main(String[] args) throws IOException {
        /*
             1.首先和Properties对象交互的文件 我们一般命名为xxx.properties
             2.编写xxx.properties文件内容时，一般不建议存储中文
             3.在properties文件中键值对的表示，可以使用= 空格 冒号 分隔键值对  以第一次出现的位置为准  一般建议使用=隔开键值对
             4.在properties配置文件中 可以使用#进行注释
         */
        //需求：读取db.properties文件中的配置信息
        //1.创建properties对象
        Properties p = new Properties();

        //2.加载properties文件到properties对象中
        p.load(new FileInputStream("day11\\aa\\db.properties"));

        //3.根据key读取数据
        Set<String> keys = p.stringPropertyNames();
        for (String key : keys) {
            System.out.println(key+" = " + p.getProperty(key));
        }
    }
}
