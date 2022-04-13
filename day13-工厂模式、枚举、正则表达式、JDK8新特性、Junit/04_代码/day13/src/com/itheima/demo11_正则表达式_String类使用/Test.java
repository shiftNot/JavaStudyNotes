package com.itheima.demo11_正则表达式_String类使用;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        /*
            String中含正则表达式的方法
                public String[] split(String regex)//将当前字符串中匹配regex正则表达式的符号作为"分隔符"来切割字符串。
                public String replaceAll(String regex,String newStr)//将当前字符串中匹配regex正则表达式的字符串替换为newStr。
         */
        //需求:使用String中的split方法，将字符串"18  4 567       99     56""以空格间隔进行分割
        String  str1 = "18  4 567       99     56";
        String[] arr1 = str1.split(" +");
        for (String s : arr1) {
            System.out.println("s = " + s);
        }

        System.out.println("---------------------------------------");
        //需求:使用String中的replaceAll方法，将"jfdk432jfdk2jk24354j47jk5l31324"中的数字使用*进行替换。
        //使用场景：敏感词过滤
        String str2 = "jfdk432jfdk2jk24354j47jk5l31324";
        String s1 = str2.replaceAll("\\d", "*");
        System.out.println("s1 = " + s1);

        String s2 = str2.replaceAll("\\d+", "*");
        System.out.println("s2 = " + s2);


        //笔试题：要求将"192.168.1.100"这个字符串以.进行分隔，将每一个元素存储到一个int数组中
        String str3 = "192.168.1.100";
        String[] arr = str3.split("\\.");
        //定义一个int类型数组
        Integer[] arrs = new Integer[arr.length];
        //循环遍历arr数组中的元素 并将元素由String转为int类型 存到arrs数组中
        for (int i = 0; i < arr.length; i++) {
            arrs[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(Arrays.toString(arrs));

        //更进一步：使用Stream流...
    }
}
