package com.itheima01_常见算法;

/*
1.概述
	顺序查找是按照序列原有顺序对数组进行遍历比较查询的基本查找算法。
2.原理
	定义一个记录查找结果的变量，初始值为-1,用于区别是否有查找结果.
	从第一个开始，与要找的数值作比较。如果相同，使用变量记录位置，并结束查找。
	对每一个元素做同样的工作，直到最后一个。此时，变量记录的就是该元素的位置；
	重复上述步骤，直到没有任何一个需要比较；

需求:定义数组存储{7, 6, 5, 4, 3}五个数据，使用普通查找找到7的位置

 */
public class Test_03顺序查找 {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 3};
        int index = getIndex(arr);
        if (index == -1) {
            System.out.println("没找到");
        } else {
            System.out.println("找到了，位置是：" + (index + 1));
        }
    }

    public static int getIndex(int[] arr) {
        //用于记录查找的位置的变量
        int index = -1;
        //要查找的数值
        int num = 5;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                index = i;
                break;
            }
        }
        return index;
    }
}
