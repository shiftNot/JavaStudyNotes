package com.itheima04_内部类;

public class Test_局部内部类 {
    public static void main(String[] args) {
        class Inner {
            public void method() {
                System.out.println("你好啊");
            }
        }
        //不能在方法的外面使用
        //只能在当前方法中使用
        Inner in = new Inner();
        in.method();

        System.out.println("你好啊");
    }
}
