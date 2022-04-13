package com.itheima03_List;

import java.util.ArrayList;
import java.util.Collections;

/*
需求:
    按照斗地主的规则，完成造牌发牌看牌的动作。
    具体规则：使用54张牌,三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌。
分析
    步骤:造牌--(洗牌)--发牌--看牌
    造牌:产生54张由花色和牌号组成的(字符串)牌面存入集合
    发牌:指定4个集合，代表三个玩家和底牌，将集合中的牌分发到四个集合中
    看牌:遍历集合查看牌面
思路:
    造牌:创建集合--创建花色数组和牌号数组--利用循环嵌套拼接53张牌,并添加到集合--添加大王和小王
    发牌:定义四个集合代表玩家和底牌--(普通for)遍历牌盒拿到每张牌，并根据索引对3取余，将牌分发给四个集合。
    看牌:打印四个集合对象

*/
public class Test_04斗地主案例 {
    public static void main(String[] args) {
        //造牌
        //1.1造一个牌盒
        ArrayList<String> pokerBox = new ArrayList<>();
        //1.2准备所有的花色和牌号
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] nums = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        //1.3通过循环嵌套，造牌，并将牌放入牌盒
        //外循环是牌号:♠A ♥A ♣A ♦A...
        //外循环是花色:♠A ♠2 ...
        //获取所有的花色
        for (String color : colors) {
            //获取所有的牌号
            for (String num : nums) {
                //组合出一张新的牌，并添加到牌盒
                String poker = color + num;
                pokerBox.add(poker);
            }
        }
        //1.4添加大王和小王
        pokerBox.add("大🃏");
        pokerBox.add("小🃏");
        System.out.println("造好的牌:"+pokerBox);
        //洗牌:day06讲
        Collections.shuffle(pokerBox);
        System.out.println("洗好的牌:"+pokerBox);
        //发牌
        //2.1定义四个集合，表示玩家和底牌
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> diPai = new ArrayList<>();
        //2.2通过普通for循环，遍历集合，执行发牌操作
        for (int i = 0; i < pokerBox.size(); i++) {//i=0~53  51-53是最后的三张底牌
            //获取每一张牌
            String poker = pokerBox.get(i);
            //判断牌是底牌还是玩家的牌
            if (i >= 51) {
                diPai.add(poker);
            } else {
                //发给玩家，需要区分3种情况，分发给3个玩家。
                if (i % 3 == 0) {
                    player1.add(poker);
                } else if (i % 3 == 1) {
                    player2.add(poker);
                } else {
                    player3.add(poker);
                }
            }
        }
        //看牌
        System.out.println("张无忌" + player1);
        System.out.println("张三丰" + player2);
        System.out.println("张翠山" + player3);
        System.out.println("底牌" + diPai);
    }
}
