package com.itheima03_Map;

import java.util.HashMap;
import java.util.Scanner;

/*
1.需求:输入一个字符串，统计字符串中每个字符出现次数。
2.分析
	获取一个字符串对象
	创建一个Map集合，键代表字符，值代表次数。
	遍历字符串得到每个字符。
	判断Map中是否有该键(public boolean containKey(Object key))
 		如果没有，第一次出现，存储次数为1；
 		如果有，则说明已经出现过，获取到对应的值进行++，再次存储。
	打印最终结果。
 */
public class Test_07Map集合练习 {
    public static void main(String[] args) {
        //创建一个集合，键是字符(Character)，值次数(Integer)
        HashMap<Character, Integer> hm = new HashMap<>();
        //录入字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请录入一个字符串");
        String str = sc.nextLine();
        //遍历字符串，获取每个字符
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //判断获取的字符，在集合的键列是否存在
            if (hm.containsKey(c)) {
                //存在,代表该字符已经出现过，需要将其次数拿出来,+1再放回去
                Integer count = hm.get(c);
                /*count++;
                hm.put(c,count);*/
                hm.put(c, ++count);
            } else {
                //不存在，代表第1次出现该字符,对应的次数就是1
                hm.put(c, 1);
            }
        }
        //输出集合中的数据
        System.out.println(hm);
    }
}
