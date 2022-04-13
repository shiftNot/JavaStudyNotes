package com.itheima01_Collections;

import java.util.ArrayList;
import java.util.Collections;

/*
1.概述
	在JDK1.5之后，定义了可变参数，用来表示一个方法需要接受的多个同类型参数。
2.定义格式
	参数类型... 形参名
3.注意事项
	一个方法只能有一个可变参数
	如果方法中有多个参数，可变参数要放到最后
4.应用场景
	用于Collections类的添加功能，如下
	public static <T> boolean addAll(Collection<T> c,T...elements):往集合中添加一些元素

需求:演示可变参数在集合工具的添加方法中的应用


 */
public class Test_03_可变参数 {
    public static void main(String[] args) {
        getSum(1);
        getSum(1, 2);
        getSum(1, 2, 3);

        ArrayList<String> list = new ArrayList<>();
        //public static <T> boolean addAll(Collection<T> c,T...elements):往集合中添加一些元素。
        Collections.addAll(list, "a", "b", "c");
        System.out.println(list);
    }

    //不知道要几个数据，个数是随机的。如果使用arr作为参数，将来必须要自己先搞一个数组出来，存储若干个数据。
    //还是相对来说比较麻烦。
    //换句话说，我们想要的是，将来有一个方法，我么想给几个参数，就给几个参数。
    public static int getSum(int... arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    //可变参数必须放到最后面
    /*public static int getSum(int... arr,int... arr2) {
       return 0;
    }
    public static int getSum(int... arr,int a) {
       return 0;
    }*/
    public static int getSum(double s, int... arr) {
        return 0;
    }
}
