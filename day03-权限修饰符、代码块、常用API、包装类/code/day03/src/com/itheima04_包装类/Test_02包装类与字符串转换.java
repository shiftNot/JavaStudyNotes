package com.itheima04_包装类;

/*
基本类型转换为String
    方式一：直接在数字后加一个空字符串 数据+""
    方式二：通过String类静态方法valueOf(Xxx)
String转换成基本类型
    方式一：指定包装类的静态方法valueOf(String s)将字符串转为对应包装类
    方式二：通过包装类的静态方法parseXxx(String s)将字符串转为对应基本类型
    注意事项：
	    String转char类型只能使用String类中非静态方法char charAt(int index)
	    数据要符合对应数据的类型格式
 */
public class Test_02包装类与字符串转换 {
    public static void main(String[] args) {
        //基本类型转字符串
        int i1 = 10;
        String s1 = i1 + "";
        System.out.println(s1);
        int i2 = 20;
        String s2 = String.valueOf(i2);
        System.out.println(s2);

        //字符串型转基本类
        String s3 = "30";
       /* Integer ii3 = Integer.valueOf(s3);
        int i3=ii3;*/
        int i3 = Integer.valueOf(s3);
        System.out.println(i3);
        String s4 = "40";
        int i4 = Integer.parseInt(s4);
        System.out.println(i4);

        //将String转为字符,char的包装类，没有类似的方法的。
        //需要使用String类中的 char charAt(索引)
        String s5="abc";
        //Character.valueOf(s5);
        System.out.println(s5.charAt(0));//'a'
    }
}
