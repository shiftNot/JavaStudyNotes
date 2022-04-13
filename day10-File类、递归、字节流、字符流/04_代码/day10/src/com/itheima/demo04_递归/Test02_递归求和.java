package com.itheima.demo04_递归;

public class Test02_递归求和 {
    public static void main(String[] args) {
        //需求：递归求1到n的累加和
        /*
            分析：
                1的累加和：1
                2的累加和：1+2
                3的累加和：1+2+3
                ...
                n-1的累加和：1+2+3+...+(n-2)+(n-1)
                n的累加和：1+2+3+...+(n-1)+n
                n的累加和计算规律：(n-1)的累加和+n
         */

        System.out.println(sum(5));
    }

    /*
        假如n=2:
            return sum(1)+2
            return 1
            1+2=3
     */
    public static int sum(int n){
        //确定递归何时结束  递归出口
        if(n==1){
            return 1;
        }
        //确定了递归什么时候使用
        return sum(n-1)+n;
    }
}
