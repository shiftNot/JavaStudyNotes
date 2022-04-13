package com.itheima02_并发包.p01Threadpool;

import java.util.concurrent.Callable;

public class MyCallable2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i < 101; i++) {
            sum += i;
        }
        return sum;
    }
}
