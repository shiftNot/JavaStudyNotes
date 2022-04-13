package com.itheima.demo10_正则表达式组成;

public class Test02_逻辑运算符 {
    public static void main(String[] args) {
        /*
            语法
                1. &&：并且   取交集
                2. | ：或者   取并集
         */
        //需求:按照如下要求，使用正则表达式，完成字符串内容的验证。
        //1. 验证字符串是小写辅音字符开头，后跟ad  除了a,e,i,o,u之外,其他的都是辅音字母  eg:[a-z&&[^aeiou]]ad
        System.out.println("aad".matches("[a-z&&[^aeiou]]ad")); //false
        System.out.println("bad".matches("[a-z&&[^aeiou]]ad")); //true
        System.out.println("1ad".matches("[a-z&&[^aeiou]]ad")); //false

        System.out.println("---------------------------------------------");
        //2. 验证字符串是aeiou中的某个字符开头，后跟ad   eg:[a|e|i|o|u]ad  或者经常可以省略，没必要写 eg:[aeiou]ad
        System.out.println("aad".matches("[a|e|i|o|u]ad")); //true
        System.out.println("bad".matches("[a|e|i|o|u]ad")); //false

        System.out.println("---------------------------------------------");
        System.out.println("aad".matches("[aeiou]ad")); //true
        System.out.println("bad".matches("[aeiou]ad")); //false


    }
}
