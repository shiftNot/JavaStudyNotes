package com.itheima03_常用API;

import java.util.Arrays;

/*
Arrays:java中数组的工具类。
       包:java.util.Arrays;
常用内容
      获取数组内容   public  static String  toString(数组对象)
      排序     public static void sort(数组对象);
 */
public class Test_09Arrays {
    public static void main(String[] args) {
        int[] arr = {98, 45, 66, 99, 77};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
