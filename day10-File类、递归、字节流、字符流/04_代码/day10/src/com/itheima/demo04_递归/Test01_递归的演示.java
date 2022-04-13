package com.itheima.demo04_递归;

public class Test01_递归的演示 {


    public static void main(String[] args) {
        /*
            递归：指的就是当前方法中调用自己的现象
            递归可能出现的问题：java.lang.StackOverflowError 栈溢出错误
            写递归：
                出口：递归的结束条件  确定什么时候结束递归【出口不能太晚】
                规律：从什么时候开始递归
            注意：
                1.递归的出口不能太晚，如果太晚了还是会导致栈内存溢出错误StackOverflowError
                2.一般要把结束递归的代码写在递归调用之前

        */
        show();
    }

    static int count = 0;

    public static void show(){
        count++;

        //递归调用
        show();

        //结束递归
        if(count==1000){
            return;
        }
    }
}
