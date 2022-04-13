package com.itheima.demo10_正则表达式组成;

public class Test04_数量词 {
    public static void main(String[] args) {
        /*
            语法
                1. X? : 0次或1次
                2. X* : 0次到多次
                3. X+ : 1次或多次
                4. X{m} : 恰好m次
                5. X{m,} : 至少m次
                6. X{m,n}: m到n次(m和n都是包含的)
         */
        //需求:按照如下要求，使用正则表达式，完成字符串内容的验证。
        //1. 验证str是否是三位数字   eg:"\\d{3}"
        System.out.println("123".matches("\\d{3}")); //true
        System.out.println("12".matches("\\d{3}"));  //fasle
        System.out.println("12a".matches("\\d{3}")); //false

        //2. 验证str是否是多位数字  eg:"\\d+"
        System.out.println("---------------------------------------");
        System.out.println("123".matches("\\d+")); //true
        System.out.println("12".matches("\\d+"));  //true
        System.out.println("1".matches("\\d+"));  //true
        System.out.println("12a".matches("\\d+")); //false

        //3. 验证手机号：1开头，第二位：3/5/8，剩下9位都是0-9的数字 eg:"1[358]\\d{9}"
        System.out.println("---------------------------------------");
        System.out.println("13512345678".matches("1[358]\\d{9}")); //true
        System.out.println("15512345678".matches("1[358]\\d{9}")); //true
        System.out.println("16512345678".matches("1[358]\\d{9}")); //false
        System.out.println("1351234567".matches("1[358]\\d{9}"));  //false

        //4. 验证qq号码：1).5--15位；2).全部是数字;3).第一位不是0   eg:"[1-9]\\d{4,14}"
        System.out.println("---------------------------------------");
        System.out.println("12345".matches("[1-9]\\d{4,14}"));          //true
        System.out.println("123456789".matches("[1-9]\\d{4,14}"));      //true
        System.out.println("012345".matches("[1-9]\\d{4,14}"));         //false
        System.out.println("12345a".matches("[1-9]\\d{4,14}"));         //false
    }
}
