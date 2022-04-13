package com.itheima01_常见算法;

/*
1.概述
	二分查找也称折半查找（Binary Search），它是一种效率较高的查找方法。
	但是，折半查找要求线性表必须采用顺序存储结构，而且表中元素按关键字有序排列。
2.原理
	找到首位置和末位置，根据这两个位置获取中间位置(首位置要小于末位置)；
	利用中间位置获取中间元素，与要查找的元素作比较。
	若查找元素比中间元素大(首位置=中间位置+1)，若查找元素比中间元素小(末位置=中间位置-1)，重复上面步骤
	若查找元素等于中间元素，即为找到，结束查找过程。

需求:将{1, 4, 16, 22, 25, 44, 55, 67, 88, 100}存入数组，并查找制定数值的位置

 */
public class Test_04二分查找 {
    public static void main(String[] args) {
        //定义数组
        int[] arr = {1, 4, 16, 22, 25, 44, 55, 67, 88, 100};
        //二分查找
        //要查找的数值
        int num = 22;
        //代表查找的位置的变量
        int index = -1;
        //左边索引变量
        int left = 0;
        //右边索引变量
        int right = arr.length - 1;
        //中间索引变量
        int middle;

        while (left <= right) {
            //a.获取中间位置
            middle = (left + right) / 2;
            //b.拿要找的数值跟中间的位置的值作比较
            if (num == arr[middle]) {
                //b.1 相同，记录找到的位置,结束循环
                index = middle;
                break;
                //b.2 要找的值比中间的值大，将left改为middle+1
            } else if (num > arr[middle]) {
                left = middle + 1;
                //b.3 要找的值比中间的值小，将right改为middle-1
            } else {
                right = middle - 1;
            }
        }
        /*for (int left = 0, right = arr.length - 1; left <= right; ) {
            //a.获取中间位置
            int middle = (left + right) / 2;
            //b.拿要找的数值跟中间的位置的值作比较
            if (num == arr[middle]) {
                //b.1 相同，记录找到的位置,结束循环
                index = middle;
                break;
                //b.2 要找的值比中间的值大，将left改为middle+1
            } else if (num > arr[middle]) {
                left = middle + 1;
                //b.3 要找的值比中间的值小，将right改为middle-1
            } else {
                right = middle - 1;
            }
        }*/

        if (index == -1) {
            System.out.println("没找到");
        } else {
            System.out.println("找到了，位置是：" + (index + 1));
        }
    }
}
