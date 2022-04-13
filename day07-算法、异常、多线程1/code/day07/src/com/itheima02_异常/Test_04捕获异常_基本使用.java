package com.itheima02_异常;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
1.概述
	处理异常的方式，在方法内通过try...catch捕获方法中存在的一个或多个问题标识,即由编码者自己处理。
	捕获异常，会避免将异常交给jvm处理，从而保障后续程序的执行。
2.格式
    格式1
            try{
                编写可能会出现异常的代码
            }catch(异常类型  e){
                处理异常的代码/记录日志/打印异常信息/继续抛出异常
            }
            ...
    格式2
            try{
            	编写可能会出现异常的代码
            }catch(异常类型1|异常类型2|...e){
            	处理异常的代码/记录日志/打印异常信息/继续抛出异常
            }
3.应用
	运行时异常,被捕获，优先以捕获形式处理
	编译时异常，被捕获，不再需要通过throws声明
	当异常出现，异常被catch捕获，try中代码不再执行,程序继续执行catch后的内容。
4.常用方法
	public String getMessage()：获取异常的描述信息,原因(提示给用户的时候,就提示错误原因
	public String toString()：获取异常的类型和异常描述信息(不用)
	public void printStackTrace()：打印异常的跟踪栈信息并输出到控制台
需求:过除数为0异常和日期解析异常演示基本使用

 */
public class Test_04捕获异常_基本使用 {
    public static void main(String[] args) {
        //method1();
        method2();
    }

    //运行时异常
    public static void method1() {
        System.out.println("开始");

        try {
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {
            //处理方案
            System.out.println("除数为0");
            //System.out.println(e.getMessage());
            //System.out.println(e.toString());
            e.printStackTrace();
        }
        System.out.println("结束");
    }

    //编译时异常
    public static void method2() {
        String time = "2000年12-12";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date result = sdf.parse(time);
            System.out.println(result);
        } catch (ParseException e) {
            System.out.println("您提供的数据有误");
            //System.out.println("getMessage："+e.getMessage());
            //System.out.println("toString："+e.toString());
            e.printStackTrace();
        }
        System.out.println("结束");
    }
}
