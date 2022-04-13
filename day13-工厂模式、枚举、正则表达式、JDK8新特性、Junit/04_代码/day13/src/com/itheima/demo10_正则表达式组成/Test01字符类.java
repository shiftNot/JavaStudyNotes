package com.itheima.demo10_正则表达式组成;

public class Test01字符类 {
    public static void main(String[] args) {
        /*
            语法----[]:匹配单个字符, -:表示范围, ^: 取反
                    [abc] a、b 或 c（简单类）
                    [^abc] 任何字符，除了 a、b 或 c（否定）
                    [a-zA-Z] a 到 z 或 A 到 Z，两头的字母包括在内（范围）
                    [a-d[m-p]] a 到 d 或 m 到 p：[a-dm-p]（并集）
                    [a-z&&[def]] d、e 或 f（交集）
                    [a-z&&[^bc]] a 到 z，除了 b 和 c：[ad-z]（减去）
                    [a-z&&[^m-p]] a 到 z，而非 m 到 p：[a-lq-z]（减去）

           boolean matches(String regex) ：告知此字符串是否匹配给定的正则表达式。
         */
        //需求:按照如下要求，使用正则表达式，完成字符串内容的验证。
        //1. 验证str是否以h开头，以d结尾，中间是a,e,i,o,u中某个字符
        System.out.println("had".matches("h[aeiou]d")); //true
        System.out.println("hbd".matches("h[aeiou]d")); //false
        System.out.println("aad".matches("h[aeiou]d")); //false
        System.out.println("ham".matches("h[aeiou]d")); //false
        System.out.println("haed".matches("h[aeiou]d")); //false

        //2. 验证str是否以h开头，以d结尾，中间不是a,e,i,o,u中的某个字符
        System.out.println("--------------------------------------------");
        System.out.println("had".matches("h[^aeiou]d")); //false
        System.out.println("hbd".matches("h[^aeiou]d")); //true
        System.out.println("aad".matches("h[^aeiou]d")); //false
        System.out.println("ham".matches("h[^aeiou]d")); //false
        System.out.println("haed".matches("h[^aeiou]d")); //false

        //3. 验证str是否a-z的任何一个小写字符开头，后跟ad   eg:"[a-z]ad"
        System.out.println("--------------------------------------------");
        System.out.println("had".matches("[a-z]ad")); //true
        System.out.println("hbd".matches("[a-z]ad")); //false
        System.out.println("aad".matches("[a-z]ad")); //true
        System.out.println("ham".matches("[a-z]ad")); //false
        System.out.println("haed".matches("[a-z]ad")); //false

        //4. 验证str是否以a-d或者m-p之间某个字符开头，后跟ad  eg:"[a-dm-p]ad"
        System.out.println("--------------------------------------------");
        System.out.println("had".matches("[a-dm-p]ad")); //false
        System.out.println("hbd".matches("[a-dm-p]ad")); //false
        System.out.println("aad".matches("[a-dm-p]ad")); //true
        System.out.println("ham".matches("[a-dm-p]ad")); //false
        System.out.println("haed".matches("[a-dm-p]ad")); //false
    }
}
