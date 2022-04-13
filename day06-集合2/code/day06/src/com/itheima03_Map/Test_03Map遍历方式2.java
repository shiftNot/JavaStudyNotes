package com.itheima03_Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
1.概述
	java.util.Map.Entry 将键值对的对应关系封装成了对象。Map的内部接口定义，具体功能由Map子类负责具体实现。
2.键值对对象类常用方法
	public K getKey()：获取Entry对象中的键。
	public V getValue()：获取Entry对象中的值
3.步骤
	获取Map中所有的键值对(Entry)对象，以Set集合形式返回。方法提示:entrySet()。
	遍历包含键值对(Entry)对象的Set集合，得到每一个键值对(Entry)对象。
	通过键值对(Entry)对象，获取Entry对象中的键与值。  方法提示:getkey() getValue()

需求:演示通过键找值的方式实现Map集合遍历

 */
public class Test_03Map遍历方式2 {
    public static void main(String[] args) {
        //创建集合对象
        Map<String, String> map = new HashMap<>();
        //添加数据
        map.put("刘备", "孙尚香");
        map.put("周瑜", "小乔");
        map.put("孙策", "大乔");
        //遍历
        //1.获取所有键值对对象的集合
        Set<Map.Entry<String, String>> entries = map.entrySet();
        //2.遍历键值对对象集合
        for (Map.Entry<String, String> entry : entries) {
            //3.获取键值对对象的键和值
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "===" + value);
        }
    }
}
