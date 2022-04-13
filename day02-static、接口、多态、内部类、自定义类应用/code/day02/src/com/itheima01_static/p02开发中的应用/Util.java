package com.itheima01_static.p02开发中的应用;

public class Util {
    //私有化构造方法
    private Util() {
    }

    //表示圆周率
    public final static double PI = 3.14;

    /**
     * 该方法用于获取数组中的最大值
     *
     * @param arr 要获取最大值的数组
     * @return 返回的结果是数组中的最大值
     */
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
