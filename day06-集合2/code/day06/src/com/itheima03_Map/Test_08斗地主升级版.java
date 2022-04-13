package com.itheima03_Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/*
需求:
    按照斗地主规则，完成造牌-洗牌-发牌-看牌的动作，要求按照牌面大小看牌。
    牌面展示规则：【大王,小王,♠2,♥2,♣2,♦2,♠A,♥A,♣A,♦A....】
分析:
    准备牌:见图。
    洗牌--发牌--看牌：使用牌号操作

步骤:
    1.造牌
    	将牌盒设计为一个HashMap<Integer，String>集合
    	将牌号作为键，制作的牌面作为值，按照映射关系，放进牌盒
    	使用一个ArrayList集合记录所有牌号
    2.洗牌
    使	用Collections类的shuffle方法对牌号进行打乱
    3.发牌
    	为每个玩家和底牌各分配一个ArrayList<Integer>记录牌号。
    	遍历牌号，通过对3取模，将牌号分配给各玩家
    	遍历中，留3张牌号，存放于底牌集合中
    4.看牌
    	对玩家和底牌牌号排序
    	遍历玩家和底牌牌号，通过获取的牌号展示牌面

 */
public class Test_08斗地主升级版 {
    public static void main(String[] args) {
        //造牌
        //1.1创建牌盒
        HashMap<Integer, String> pokerBox = new HashMap<>();
        //1.2造存储牌号的List集合
        ArrayList<Integer> pokerKeys = new ArrayList<>();
        //1.3造牌，并将牌面盒牌号放入到牌盒，以及将牌号放入到指定的List集合。
        int index = 54;
        pokerKeys.add(index);
        pokerBox.put(index--, "大🃏");
        pokerKeys.add(index);
        pokerBox.put(index--, "小🃏");

        String[] colors = "♠,♥,♣,♦".split(",");
        String[] nums = "2,A,K,Q,J,10,9,8,7,6,5,4,3".split(",");
        for (String num : nums) {
            for (String color : colors) {
                String poker = color + num;
                pokerKeys.add(index);
                pokerBox.put(index--, poker);
            }
        }
        //System.out.println(pokerBox);
        //洗牌
        Collections.shuffle(pokerKeys);
        //System.out.println(pokerKeys);
        //发牌
        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> diPai = new ArrayList<>();
        for (int i = 0; i < pokerKeys.size(); i++) {
            Integer pokerkey = pokerKeys.get(i);
            //留最后3种存入底牌
            if (i >= 51) {
                diPai.add(pokerkey);
            } else {
                if (i % 3 == 0) {
                    player1.add(pokerkey);
                } else if (i % 3 == 1) {
                    player2.add(pokerkey);
                } else {
                    player3.add(pokerkey);
                }
            }
        }
        //看牌
        showPoker("张无忌:", player1, pokerBox);
        showPoker("张三丰:", player2, pokerBox);
        showPoker("张翠山:", player3, pokerBox);
        showPoker("底牌:", diPai, pokerBox);
    }

    /**
     * 该方法用于，对牌号进行排序，并展示牌面
     *
     * @param name     玩家的名字
     * @param player   玩家的牌号
     * @param pokerBox 牌盒
     */
    public static void showPoker(String name, ArrayList<Integer> player, HashMap<Integer, String> pokerBox) {
        //对玩家或底牌的牌号进行排序(降序)
        Collections.sort(player, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        System.out.print(name);
        System.out.print("[");
        for (int i = 0; i < player.size(); i++) {
            Integer key = player.get(i);
            String poker = pokerBox.get(key);
            if (i == player.size() - 1) {
                System.out.print(poker);
            } else {
                System.out.print(poker + ",");
            }
        }
        System.out.println("]");
    }
}
