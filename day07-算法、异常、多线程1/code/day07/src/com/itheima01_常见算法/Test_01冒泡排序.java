package com.itheima01_常见算法;

import java.util.Arrays;

/*
1.概述
	冒泡排序（Bubble Sort），是一种计算机科学领域的较简单的排序算法。
2.原理
	从第一个开始，比较相邻的元素。如果前面比后面大，就交换他们两个；
	对每一对相邻元素做同样的工作，直到最后一对。此时，最后的元素会是最大的数；
	从头开始对所有的元素重复以上的步骤，除了上一轮最后一个；
	重复上述步骤，直到没有任何一对需要比较；

需求:在数组中存储，{7, 6, 5, 4, 3}五个数据，并使用冒泡排序进行排序

 */
public class Test_01冒泡排序 {
    public static void main(String[] args) {
        //定义数组
        int[] arr = {7, 6, 5, 4, 3};
        //比较的轮数=数组的长度-1
        for (int i = 0; i < arr.length - 1; i++) {//i=0~4
            //进行两两比较
            //为了避免索引越界，需要让长度-1
            for (int j = 0; j < arr.length - 1-i; j++) {
                //System.out.println("j"+j);
                //j  j+1
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        //打印数组结果
        System.out.println(Arrays.toString(arr));
    }
}
