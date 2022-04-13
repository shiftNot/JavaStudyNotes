package com.itheima.demo10_正则表达式组成;

public class Test05_分组 {
    public static void main(String[] args) {
        /*
        语法
            ():将一系列操作作为一个整体来理解。
                小括号表示一组 多个小括号表示多组   \\1拿到就是第一组小括号中的数据   \\2拿到就是第二组小括号中的数据
         */
        //需求:按照如下要求，使用正则表达式，完成"DG8FV-B9TKY-FRT9J-99899-XPQ4G"序列号字符串内容的验证。
        //分析：1.可以将"DG8FV-B9TKY-FRT9J-99899-XPQ4G"分为5段组成 每一段出现5个字符[A-Z0-9]
        // 2. 前四段就是[A-Z0-9]{5}-    最后一段就是[A-Z0-9]{5}
        //eg："([A-Z0-9]{5}-){4}[A-Z0-9]{5}"
        System.out.println("DG8FV-B9TKY-FRT9J-99899-XPQ4G".matches("([A-Z0-9]{5}-){4}[A-Z0-9]{5}")); //true

        //需求：匹配叠词 ：开开心心 快快乐乐   ...  aabb格式  eg：(.){2}(.){2} = (.){4}
        //正常定义正则表达式："(.)\\1(.)\\2"        \\1表示第一组   \\2表示第二组
        System.out.println("开开心心".matches("(.){2}(.){2}"));     //true
        System.out.println("快快乐乐".matches("(.){4}"));           //true
        System.out.println("开心不了".matches("(.){4}"));           //true

        System.out.println("------------------------------------");
        System.out.println("开开心心".matches("(.)\\1(.)\\2"));     //true
        System.out.println("快快乐乐".matches("(.)\\1(.)\\2"));     //true
        System.out.println("开心不了".matches("(.)\\1(.)\\2"));     //false

        //哈哈哈嘿嘿嘿 ... aaabbb格式  eg:"(.)\\1{2}(.)\\2{2}"
        System.out.println("------------------------------------");
        System.out.println("哈哈哈嘿嘿嘿".matches("(.)\\1{2}(.)\\2{2}"));//true
        System.out.println("哈黑哈嘿嘿嘿".matches("(.)\\1{2}(.)\\2{2}"));//false

        //aabbcc  "(.)\\1(.)\\2(.)\\3"

        //abba   "(.)(.)\\2\\1"
        System.out.println("abba".matches("(.)(.)\\2\\1"));   //true

    }

}
