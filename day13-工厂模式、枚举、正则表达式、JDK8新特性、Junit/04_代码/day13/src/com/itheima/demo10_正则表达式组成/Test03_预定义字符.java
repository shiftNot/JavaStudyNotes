package com.itheima.demo10_正则表达式组成;

public class Test03_预定义字符 {
    public static void main(String[] args) {
        /*
            语法
                1. "." ：匹配任何字符。如果要表示一个字符点,那么就得使用\\.
                2. "\d"：任何数字[0-9]的简写；
                3. "\D"：任何非数字\[^0-9]的简写；
                4. "\s"：空白字符：[\t\n\x0B\f\r] 的简写
                5. "\S"：非空白字符：\[^\s\] 的简写
                6. "\w"：单词字符：[a-zA-Z_0-9]的简写
                7. "\W"：非单词字符：\[^\w\]

         */
        //需求:按照如下要求，使用正则表达式，完成字符串内容的验证。
        //1. 验证str是否3位数字    eg:"[0-9][0-9][0-9]"   "\\d\\d\\d"  "\\d{3}"
        System.out.println("123".matches("\\d\\d\\d")); //true
        System.out.println("12".matches("\\d\\d\\d"));  //fasle
        System.out.println("12a".matches("\\d\\d\\d")); //false

        System.out.println("---------------------------------------------------");
        //2. 验证手机号：1开头，第二位：3/5/8，剩下9位都是0-9的数字  eg: "1[358]\\d\\d\\d\\d\\d\\d\\d\\d\\d"
        System.out.println("13512345678".matches("1[358]\\d\\d\\d\\d\\d\\d\\d\\d\\d")); //true
        System.out.println("15512345678".matches("1[358]\\d\\d\\d\\d\\d\\d\\d\\d\\d")); //true
        System.out.println("16512345678".matches("1[358]\\d\\d\\d\\d\\d\\d\\d\\d\\d")); //false
        System.out.println("1351234567".matches("1[358]\\d\\d\\d\\d\\d\\d\\d\\d\\d"));  //false

        //3. 验证字符串是否以h开头，以d结尾，中间是任何字符  eg: "h.d"
        System.out.println("---------------------------------------------------");
        System.out.println("aad".matches("h.d"));   //false
        System.out.println("had".matches("h.d"));   //true
        System.out.println("h-d".matches("h.d"));   //true
        System.out.println("h.d".matches("h.d"));   //true
        System.out.println("h d".matches("h.d"));   //true     中间一个空格
        System.out.println("h  d".matches("h.d"));   //false   中间两个空格

        //4. 验证str是否是：h.d   eg: "h\\.d"
        System.out.println("---------------------------------------------------");
        System.out.println("aad".matches("h\\.d"));   //false
        System.out.println("had".matches("h\\.d"));   //false
        System.out.println("h-d".matches("h\\.d"));   //false
        System.out.println("h.d".matches("h\\.d"));   //true
    }
}
