package com.itheima.demo09_正则表达式初体验;

public class Test01 {
    public static void main(String[] args) {
        /*
            正则表达式作用:用来验证指定的字符串是否匹配某个规则,规则由正则表达式来描述。
            使用场景：对数据使用某种规则进行校验
         */
        //需求:分别使用if语句和正则表达式，对用户输入一个QQ号码做验证操作。要求同时符合一下三个规则才算通过验证。
        //规则1:QQ号码必须是5--15位长度
        //规则2:而且必须全部是数字
        //规则3:而且首位不能为0
        System.out.println(checkQQ01("1234"));          //false
        System.out.println(checkQQ01("12345678910"));   //true
        System.out.println(checkQQ01("12345a"));        //false
        System.out.println(checkQQ01("012345"));        //false

        System.out.println("---------------------------------");

        System.out.println(checkQQ02("1234"));          //false
        System.out.println(checkQQ02("12345678910"));   //true
        System.out.println(checkQQ02("12345a"));        //false
        System.out.println(checkQQ02("012345"));        //false
    }

    /**
     * 使用if验证输入的字符串是否符合QQ号码规则
     * @param qq
     * @return
     */
    public static boolean checkQQ01(String qq){
        //规则1:QQ号码必须是5--15位长度
        if (qq.length()<5 || qq.length()>15){
            return false;
        }
        //规则2:而且必须全部是数字
        for (int i = 0; i <qq.length() ; i++) {
            //获取字符
            char c = qq.charAt(i);
            //判断字符
            if(c<'0' || c>'9'){
                return false;
            }
        }
        //规则3:而且首位不能为0
        if(qq.charAt(0)=='0'){
            return false;
        }
        //符合规则 返回true
        return true;
    }

    /**
     * 使用正则表达式验证QQ号码是否满足规则
     * @param qq
     * @return
     */
    public static boolean checkQQ02(String qq){
        return qq.matches("[1-9]\\d{4,14}");
    }
}
