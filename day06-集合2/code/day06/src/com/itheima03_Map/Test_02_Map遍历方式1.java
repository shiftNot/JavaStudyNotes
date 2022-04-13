package com.itheima03_Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
1.概述
	通过元素中的键，获取键所对应的值。
2.步骤
	取Map中所有的键集，返回一个Set集合存储所有的键。方法提示:keyset()
	遍历键的Set集合，得到每一个键。
	根据键，获取键所对应的值。方法提示:get(K key)

需求:演示通过键找值的方式实现Map集合遍历

 */
public class Test_02_Map遍历方式1 {
    public static void main(String[] args) {
        //创建集合对象
        Map<String, String> map = new HashMap<>();
        //添加数据
        map.put("刘备", "孙尚香");
        map.put("周瑜", "小乔");
        map.put("孙策", "大乔");
        //遍历
        //1.获取所有的键的集合
        Set<String> keys = map.keySet();
        //2.遍历键的集合，获取对应的值
        for (String key : keys) {
            String value = map.get(key);
            System.out.println(key + "===" + value);
        }
    }
}
