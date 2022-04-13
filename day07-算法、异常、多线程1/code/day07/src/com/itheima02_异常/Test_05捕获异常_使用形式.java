package com.itheima02_异常;
/*
使用形式
	多个异常分别try，分别捕获(处理)。
	多个异常一次try，分别捕获(处理)。
	多个异常一次try，一次捕获(处理)。
需求:通过除数为0异常，和空指针异常，演示使用形式
 */

public class Test_05捕获异常_使用形式 {
    public static void main(String[] args) {
        //method1();
        //method2();
        method3();
    }

    //分别try，分别处理
    public static void method1() {
        try {
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        int[] arr = null;
        try {
            System.out.println(arr[0]);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    //一次try,分别处理
    public static void method2() {
        try {
            System.out.println(10 / 0);
            int[] arr = null;
            System.out.println(arr[0]);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    //一次try,一次捕获
    public static void method3() {
        /*try {
            System.out.println(10 / 0);
            int[] arr = null;
            System.out.println(arr[0]);
        }catch (Exception e){
            e.printStackTrace();
        }*/
        try {
            System.out.println(10 / 0);
            int[] arr = null;
            System.out.println(arr[0]);
        }catch (ArithmeticException|NullPointerException e){
            e.printStackTrace();
        }
    }
}
