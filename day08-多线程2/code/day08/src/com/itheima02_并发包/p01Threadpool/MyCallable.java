package com.itheima02_并发包.p01Threadpool;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Double> {
    @Override
    public Double call() throws Exception {
        return Math.random() * 10;
    }
}
