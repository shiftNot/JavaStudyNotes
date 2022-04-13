package com.itheima03_常用API;

/*
需求:在控制台输出100000次内容，计算这段代码执行了多少毫秒
步骤:
    获取开始时间
    干活
    获取结束时间
    结束时间-开始时间
 */
public class Test_07SystemTest {
    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();
        //干活
        run();
        //获取结束时间
        long endTime = System.currentTimeMillis();
        //结束时间-开始时间
        long usedTime = endTime - startTime;
        //打印使用的时间
        System.out.println("使用了" + usedTime + "毫秒");
    }

    public static void run() {
        for (int i = 1; i <= 100000; i++) {
            System.out.println("第" + i + "次打印内容");
        }
    }
}
