package com.itheima01_常见算法;

import java.util.Arrays;

/*
1.概述
	选择排序（Selection sort）是一种简单直观的排序算法。
2.原理
	从第一个开始，与后面元素比较。如果前面比后面大，就交换他们两个；
	用第一个与后续每一个做同样的工作，直到最后一个。此时，最前面的元素会是最小值。
	从第二个开始对所有的元素重复以上的步骤，不含上一轮最前一个；
	重复上述步骤，直到没有任何一对需要比较；

需求:在数组中存储，{7, 6, 5, 4, 3}五个数据，并使用选择进行排序

 */
public class Test_02选择排序 {
    public static void main(String[] args) {
        //定义数组
        int[] arr = {7, 6, 5, 4, 3};
        //比较的轮数=数组的长度-1
        for (int i = 0; i < arr.length - 1; i++) {//i=0~3
            for (int j = i; j < arr.length - 1; j++) {
                System.out.println("j=" + j);
                //0   j+1
                if (arr[i] > arr[j + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
       /* //比较内容，进行交换
        for (int j = 0; j < arr.length - 1; j++) {//j=0~3
            //0   j+1
            if (arr[0] > arr[j + 1]) {
                int temp = arr[0];
                arr[0] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        for (int j = 0 + 1; j < arr.length - 1; j++) {//j=1~3
            //0   j+1
            if (arr[1] > arr[j + 1]) {
                int temp = arr[1];
                arr[1] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        for (int j = 0 + 2; j < arr.length - 1; j++) {//j=2~3
            //0   j+1
            if (arr[2] > arr[j + 1]) {
                int temp = arr[2];
                arr[2] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        for (int j = 0 + 3; j < arr.length - 1; j++) {//j=2~3
            //0   j+1
            if (arr[3] > arr[j + 1]) {
                int temp = arr[3];
                arr[3] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }*/
    }
}
