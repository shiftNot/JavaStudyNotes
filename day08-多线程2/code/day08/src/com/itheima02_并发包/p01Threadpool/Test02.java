package com.itheima02_并发包.p01Threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
1.需求:
	使用线程池方式执行任务,返回1-100的和。
2.分析
	创建线程任务实现类，定义求和操作(因为需要返回求和结果,所以使用Callable方式的任务)
	创建线程池，指定线程数
	提交线程任务，获取现承结果对象
	获取线程运行返回结果


*/
public class Test02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程对象
        ExecutorService es = Executors.newFixedThreadPool(1);
        //创建任务对象
        MyCallable2 mc = new MyCallable2();
        //将任务提交给线程池对象
        Future<Integer> result = es.submit(mc);
        //获取结果
        System.out.println(result.get());
        //关闭线程池
        //es.shutdown();
    }
}
