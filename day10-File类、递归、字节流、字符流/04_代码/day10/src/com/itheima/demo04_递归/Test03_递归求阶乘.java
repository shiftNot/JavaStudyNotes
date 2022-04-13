package com.itheima.demo04_递归;

public class Test03_递归求阶乘 {
    public static void main(String[] args) {
        //需求：递归求1到n的阶乘
        /*
            分析：
                1的阶乘：1
                2的阶乘：1*2
                3的阶乘：1*2*3
                ...
                n-1的阶乘：1*2*3*...*(n-2)*(n-1)
                n的阶乘：1*2*3*...*(n-1)*n
                计算n的阶乘：
                    规律：n-1的阶乘*n
                    出口：当n-1的时候 结束递归
         */
        int jc = jieCheng(5);//1*2*3*4*5=120
        System.out.println("jc = " + jc);
    }

    public static int jieCheng(int n){
        if(n==1){
            return 1;
        }
        return jieCheng(n-1)*n;
    }

}
