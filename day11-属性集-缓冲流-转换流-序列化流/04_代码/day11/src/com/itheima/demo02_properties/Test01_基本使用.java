package com.itheima.demo02_properties;

import java.util.Properties;
import java.util.Set;

public class Test01_基本使用 {
    public static void main(String[] args) {
        /*
        概述
            java.util.Properties 继承于Hashtable，表示一个持久的属性集。
            它使用键值结构存储数据，每个键及其对应值都是一个字符串。
        该类被许多Java类使用，比如获取系统属性时，System.getProperties()就是返回Properties对象。

        构造方法 public Properties() :创建一个空的属性列表。
        常用方法
            public Object setProperty(String key, String value): 保存一对属性。
            public String getProperty(String key) :使用此属性列表中指定的键搜索属性值。
            public Set<String> stringPropertyNames() :所有键的名称的集合。

       总结：Properties就是类似于一个map集合 使用键值结构存储数据  key不能重复
       使用场景：用于读取项目中配置文件数据
         */
        //需求：获取系统属性：
        /*Properties properties = System.getProperties();
        Set<String> keys = properties.stringPropertyNames();
        for (String key : keys) {
            System.out.println(key+"-->"+properties.getProperty(key));
        }
        System.out.println("获取当前计算机用户名："+properties.getProperty("user.name"));*/


        //需求：演示属性集构造方法和常用方法
        //1.创建Properties对象
        Properties p = new Properties();
        //2.存数据
        p.setProperty("k1","v1");
        p.setProperty("k2","v2");
        p.setProperty("k3","v3");
        //3.取数据

        System.out.println("k2 = " + p.getProperty("k2"));

        //获取Properties属性值中的所有键的集合
        Set<String> strings = p.stringPropertyNames();
        for (String string : strings) {
            System.out.println(string+" = " +p.getProperty(string));
        }


    }
}
